package me.klivenko.leetcode.top_interview_questions.medium.dynamic;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 */


/*
    https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/808/
 */
public class Unique_Paths {

    public static void main(String[] args) {
        run(3, 2, 3);
        run(7, 3, 28);
    }

    public static void run(int m, int n, int correctAnswer) {
        Utils.print("start app with: ", m + " " + n);
        int result = new Solution().uniquePaths(m, n);
        Assert.equals(correctAnswer, result);
    }

    public static class Solution {
        public int uniquePaths(int m, int n) {
            int[][] grid = new int[m][n];

            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(i == 0 || j == 0) {
                        grid[i][j] = 1;
                        continue;
                    }
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
                }
            }

            return grid[m - 1][n - 1];
        }
    }
}
