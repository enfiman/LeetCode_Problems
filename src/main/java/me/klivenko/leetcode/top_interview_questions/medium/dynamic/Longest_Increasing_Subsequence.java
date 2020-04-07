package me.klivenko.leetcode.top_interview_questions.medium.dynamic;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
 */


import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.Arrays;

/*
https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/810/
 */
public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        run(new int[]{10,9,2,5,3,7,101,18}, 4);
    }

    public static void run(int[] nums, int correctAnswer) {
        Utils.print("start app with: ", nums);
        int result = new Solution().lengthOfLIS(nums);
        Assert.equals(correctAnswer, result);
    }

    public static class Solution {
        public int lengthOfLIS(int[] nums) {
            if(nums.length == 0) return 0;
            int[] dp = new int[nums.length];

            Arrays.fill(dp, 1);

            int max = 1;
            for(int i = 1; i < nums.length; i++){
                for(int j = 0; j < i; j++){

                    if(nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        max = Math.max(dp[i], max);
                    }
                }
            }


            return max;
        }
    }
}
