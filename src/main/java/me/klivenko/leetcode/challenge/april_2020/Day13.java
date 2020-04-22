package me.klivenko.leetcode.challenge.april_2020;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.*;

/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
*/


/*
    https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
 */
public class Day13 {
    public static void main(String[] args) {
        run(new int[]{0, 1}, 2);
        run(new int[]{0, 1, 0}, 2);
    }

    public static void run(int[] arr, int correctAnswer) {
        Utils.print("start app with: ", arr);
        int result = new Solution().findMaxLength(arr);
        Assert.equals(correctAnswer, result);
    }

    public static class Solution {
        public int findMaxLength(int[] nums) {
            Map<Integer, Integer> map = new HashMap();
            map.put(0, -1);

            int maxLen = 0, count = 0;
            for (int i = 0; i < nums.length; i++) {
                count = count + (nums[i] == 1 ? 1 : -1);

                if (map.containsKey(count)) {
                    maxLen = Math.max(i - map.get(count), maxLen);
                } else {
                    map.put(count, i);
                }
            }

            return maxLen;
        }
    }
}
