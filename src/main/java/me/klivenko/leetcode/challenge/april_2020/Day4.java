package me.klivenko.leetcode.challenge.april_2020;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

/*
    https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3286/
 */
public class Day4 {
    public static void main(String[] args) {
        run(new int[]{0,1,0,3,12}, new int[]{1,3,12,0,0});
    }

    public static void run(int[] nums, int[] correctAnswer) {
        Utils.print("start app with: ", nums);
        int[] result = new Solution().moveZeroes(nums);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        public int[] moveZeroes(int[] nums) {
            int slow = 0;
            int fast = 0;

            while(fast != nums.length){
                nums[slow] = nums[fast];
                if(nums[fast] != 0){
                    fast++;
                    slow++;
                }else{
                    fast++;
                }
            }

            for(int i = slow; i < nums.length; i++){
                nums[i] = 0;
            }

            return nums;
        }
    }
}
