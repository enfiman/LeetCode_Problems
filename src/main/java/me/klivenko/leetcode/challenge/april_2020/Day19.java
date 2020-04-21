package me.klivenko.leetcode.challenge.april_2020;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */

/*
    https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3304/
 */
public class Day19 {
    class Solution {
        private int binarySearch(int[] nums, int left, int right, int target) {
            int center = (left + right) / 2;

            if (left > right) return -1;
            if (nums[center] == target) return center;

            //if left part is sorted
            if (nums[left] <= nums[center]) {
                //and we are here, search in this place
                if (target >= nums[left] && target <= nums[center]) {
                    return binarySearch(nums, left, center, target);
                }
                //not here, go to right part
                return binarySearch(nums, center + 1, right, target);
            }

            //if right part is sorted

            //if we in the middle of right part
            if (target >= nums[center + 1] && target <= nums[right]) {
                return binarySearch(nums, center + 1, right, target);
            }
            return binarySearch(nums, left, center, target);
        }

        public int search(int[] nums, int target) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
    }
}
