package me.klivenko.leetcode.challenge.april_2020;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

/*
  Product of Array Except Self
Solution
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/


/*
    https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3300/
 */
public class Day15 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] result = new int[nums.length];

            result[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                result[i] = result[i - 1] * nums[i - 1];
            }

            int r = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                result[i] = result[i] * r;
                r *= nums[i];
            }

            return result;
        }
    }
}
