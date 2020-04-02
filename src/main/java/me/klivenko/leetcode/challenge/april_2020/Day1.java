package me.klivenko.leetcode.challenge.april_2020;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.HashSet;
import java.util.Set;

/*
    https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3283/
 */
public class Day1 {
    public static void main(String[] args) {
        run(new int[]{2, 2, 1}, 1);
        run(new int[]{4, 1, 2, 1, 2}, 4);
    }

    public static void run(int[] nums, int correctAnswer) {
        Utils.print("start app with: ", nums);
        int result = new Solution().singleNumber(nums);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        public int singleNumber(int[] nums) {
           Set<Integer> set = new HashSet();

           for(int i = 0; i < nums.length; i++){
               int val = nums[i];

               if(set.contains(val)) {
                   set.remove(val);
               } else {
                   set.add(val);
               }
           }

           return set.iterator().next();
        }
    }
}
