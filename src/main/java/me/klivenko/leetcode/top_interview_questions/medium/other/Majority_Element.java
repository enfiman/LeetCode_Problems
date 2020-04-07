package me.klivenko.leetcode.top_interview_questions.medium.other;

/*
    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.Arrays;

/*
    https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/824/
 */
public class Majority_Element {
    public static void main(String[] args) {
        run(new int[]{3,2,3}, 3);
        run(new int[]{2,2,1,1,1,2,2}, 2);
    }

    public static void run(int[] nums, int correctAnswer) {
        Utils.print("start app with: ", nums);
        int result = new Solution().majorityElement(nums);
        Assert.equals(correctAnswer, result);
    }

    public static class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
}
