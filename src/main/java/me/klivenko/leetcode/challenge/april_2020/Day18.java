package me.klivenko.leetcode.challenge.april_2020;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/


import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.LinkedList;
import java.util.Queue;

/*
    https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/
 */
public class Day18 {
    public static void main(String[] args) {
        run(new char[][]{
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray()
        }, 1);


        run(new char[][]{
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()
        }, 3);
    }

    public static void run(char[][] grid, int correctAnswer) {
        Utils.print("start app with: ", Utils.convert(grid));
        int result = new Solution().numIslands(grid);
        Assert.equals(correctAnswer, result);
    }

    public static class Solution {
        int islandCounter = 0;
        Queue<Point> queue = new LinkedList();

        static class Point {
            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return "Point{" +
                        "x=" + x +
                        ", y=" + y +
                        '}';
            }

            int x, y;
        }

        public void checkDirection(Point curPoint, char[][] grid, int xGo, int yGo) {
            int newX = curPoint.x + xGo;
            int newY = curPoint.y + yGo;

            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                if (grid[newX][newY] == '1') {
                    queue.add(new Point(newX, newY));
                    grid[newX][newY] = '2';
                }
            }
        }

        public void findIsland(char[][] grid) {
            while (true) {
                Point curPoint = queue.poll();
                if (curPoint == null) {
                    islandCounter++;
                    break;
                }

                checkDirection(curPoint, grid, 0, 1);
                checkDirection(curPoint, grid, 0, -1);
                checkDirection(curPoint, grid, 1, 0);
                checkDirection(curPoint, grid, -1, 0);
            }
        }

        public int numIslands(char[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        grid[i][j] = '2';
                        queue.add(new Point(i, j));
                        findIsland(grid);
                    }
                }
            }
            return islandCounter;
        }
    }
}
