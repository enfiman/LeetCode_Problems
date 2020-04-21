package me.klivenko.leetcode.challenge.april_2020;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

/*
    https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3303/
 */
public class Day18 {
    public static void main(String[] args) {
        run(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }, 7);


        run(new int[][]{
                {7, 1, 3, 5, 8, 9, 9, 2, 1, 9, 0, 8, 3, 1, 6, 6, 9, 5},
                {9, 5, 9, 4, 0, 4, 8, 8, 9, 5, 7, 3, 6, 6, 6, 9, 1, 6},
                {8, 2, 9, 1, 3, 1, 9, 7, 2, 5, 3, 1, 2, 4, 8, 2, 8, 8},
                {6, 7, 9, 8, 4, 8, 3, 0, 4, 0, 9, 6, 6, 0, 0, 5, 1, 4},
                {7, 1, 3, 1, 8, 8, 3, 1, 2, 1, 5, 0, 2, 1, 9, 1, 1, 4},
                {9, 5, 4, 3, 5, 6, 1, 3, 6, 4, 9, 7, 0, 8, 0, 3, 9, 9},
                {1, 4, 2, 5, 8, 7, 7, 0, 0, 7, 1, 2, 1, 2, 7, 7, 7, 4},
                {3, 9, 7, 9, 5, 8, 9, 5, 6, 9, 8, 8, 0, 1, 4, 2, 8, 2},
                {1, 5, 2, 2, 2, 5, 6, 3, 9, 3, 1, 7, 9, 6, 8, 6, 8, 3},
                {5, 7, 8, 3, 8, 8, 3, 9, 9, 8, 1, 9, 2, 5, 4, 7, 7, 7},
                {2, 3, 2, 4, 8, 5, 1, 7, 2, 9, 5, 2, 4, 2, 9, 2, 8, 7},
                {0, 1, 6, 1, 1, 0, 0, 6, 5, 4, 3, 4, 3, 7, 9, 6, 1, 9}}, 85);
    }

    public static void run(int[][] grid, int correctAnswer) {
        Utils.print("start app with: ", Utils.convert(grid));
        int result = new Solution().minPathSum(grid);
        Assert.equals(correctAnswer, result);
    }


    //DP
    public static class Solution {
        public int minPathSum(int[][] grid) {
            int[][] path = new int[grid.length][grid[0].length];
            path[0][0] = grid[0][0];

            for (int i = 1; i < grid.length; i++) {
                path[i][0] = path[i - 1][0] + grid[i][0];
            }

            for (int i = 1; i < grid[0].length; i++) {
                path[0][i] = path[0][i - 1] + grid[0][i];
            }

            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];
                }
            }

            return path[path.length - 1][path[0].length - 1];
        }
    }

    //Time Limit
    public static class SolutionDFS {
        private int dfs(int[][] grid, int i, int j) {
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                return grid[i][j];
            }

            if (i < grid.length - 1 && j < grid[0].length - 1) {
                int l = grid[i][j] + dfs(grid, i + 1, j);
                int r = grid[i][j] + dfs(grid, i, j + 1);
                return Math.min(l, r);
            }

            if (i < grid.length - 1) {
                return grid[i][j] + dfs(grid, i + 1, j);
            }

            if (j < grid[0].length - 1) {
                return grid[i][j] + dfs(grid, i, j + 1);
            }

            return 0;
        }

        public int minPathSum(int[][] grid) {
            int minValue = dfs(grid, 0, 0);

            return minValue;
        }
    }
}
