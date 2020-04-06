package me.klivenko.leetcode.top_interview_questions.medium.sorting_searching;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.List;

/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

 */

/*
https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/798/
 */
public class Sort_Colors {
    public static void main(String[] args) {
        run(new int[]{2,0,2,1,1,0}, new int[]{0,0,1,1,2,2});
    }

    public static void run(int[] nums, int[] correctAnswer) {
        Utils.print("start app with: ", nums);
        new Solution().sortColors(nums);
        Assert.equals(correctAnswer, nums);
    }

        static class Solution {
        public void sortColors(int[] nums) {
            int[] counter = new int[3];
            for(int i = 0; i < counter.length; i++) {
                counter[i] = 0;
            }

            for(int i = 0; i < nums.length; i++) {
                counter[nums[i]]++;
            }

            int globalCounter = 0;
            for(int i = 0; i < counter.length; i++) {
                for(int j = 0; j < counter[i]; j++){
                    nums[globalCounter++] = i;
                }
            }
        }
    }
}
