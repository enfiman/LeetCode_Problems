package me.klivenko.leetcode.challenge.april_2020;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

/*
    https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3285/
 */
public class Day3 {
    public static void main(String[] args) {
        run(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6);
    }

    public static void run(int[] nums, int correctAnswer) {
        Utils.print("start app with: ", nums);
        int result = new Solution().maxSubArray(nums);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int theMax = nums[0];

            for(int i = 1; i < nums.length; i++){
                max = Math.max(nums[i], max + nums[i]);
                theMax = Math.max(max, theMax);
            }

            return theMax;
        }
    }
}
