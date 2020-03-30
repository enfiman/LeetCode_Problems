package me.klivenko.leetcode.solved;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.LinkedList;
import java.util.Queue;

/*
    Let's play the minesweeper game (Wikipedia, online game)!

You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:

If a mine ('M') is revealed, then the game is over - change it to 'X'.
If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
Return the board when no more squares will be revealed.


Example 1:

Input:

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

Output:

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Explanation:

Example 2:

Input:

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Click : [1,2]

Output:

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Explanation:



Note:

The range of the input matrix's height and width is [1,50].
The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
The input board won't be a stage when game is over (some mines have been revealed).
For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
 */

/*
    tags: bfs, dfs, graph
 */

/*
    https://leetcode.com/problems/minesweeper/
 */
public class P529_Minesweeper {

    public static void main(String[] args) {

        char[][] input1 = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};

        char[][] answer1 = {{'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};
        run(input1, new int[]{3, 0}, answer1);


        char[][] input2 = {{'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};

        char[][] answer2 = {{'B', '1', 'E', '1', 'B'},
                {'B', '1', 'X', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};

        run(input2, new int[]{1, 2}, answer2);
    }

    public static void run(char[][] board, int[] click, char[][] correctAnswer) {
        Utils.printBreakLine();
        Utils.print("start app with: ", board);
        Utils.print("click: ", click);

        char[][] result = new Solution().updateBoard(board, click);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {

        private int[][] directions = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
                {1, 1},
                {-1, -1},
                {1, -1},
                {-1, 1}
        };

        private boolean isMine(char[][] board, int[] item) {
            return board[item[0]][item[1]] == 'M';
        }

        private boolean isValidIndex(char[][] board, int newI, int newJ) {
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                return true;
            }
            return false;
        }

        private int countMines(char[][] board, int x, int y){
            int minesCount = 0;
            for (int i = 0; i < directions.length; i++) {
                int newI = x + directions[i][0];
                int newJ = y + directions[i][1];

                if (isValidIndex(board, newI, newJ)) {
                    if (board[newI][newJ] == 'M') {
                        minesCount++;
                    }
                }
            }

            return minesCount;
        }

        public char[][] updateBoard(char[][] board, int[] click) {
            if (board.length == 0 || board[0].length == 0) {
                return board;
            }
            if (isMine(board, click)) {
                board[click[0]][click[1]] = 'X';
                return board;
            }

            Queue<int[]> queue = new LinkedList();
            queue.add(click);

            while (!queue.isEmpty()) {
                int[] item = queue.poll();
                if (board[item[0]][item[1]] != 'E') continue;

                int minesCount = countMines(board, item[0], item[1]);

                if (minesCount == 0) {
                    board[item[0]][item[1]] = 'B';

                    for (int i = 0; i < directions.length; i++) {
                        int newI = item[0] + directions[i][0];
                        int newJ = item[1] + directions[i][1];

                        if (isValidIndex(board, newI, newJ)) {
                            if (board[newI][newJ] == 'E') {
                                queue.add(new int[]{newI, newJ});
                            }
                        }
                    }
                } else {
                    board[item[0]][item[1]] = (char)(minesCount + '0');
                }
            }

            return board;
        }
    }
}
