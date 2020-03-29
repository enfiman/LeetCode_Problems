package me.klivenko.leetcode.contest.w182;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

/*
1394. Find Lucky Integer in an Array
Difficulty:Easy
Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.

Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.


Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
Example 2:

Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
Example 3:

Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.
Example 4:

Input: arr = [5]
Output: -1
Example 5:

Input: arr = [7,7,7,7,7,7,7]
Output: 7


Constraints:

1 <= arr.length <= 500
1 <= arr[i] <= 500
 */

/*
    https://leetcode.com/contest/weekly-contest-182/problems/find-lucky-integer-in-an-array/
 */
public class P5368_Find_Lucky_Integer_in_an_Array {
    public static void main(String[] args) {
        run(new int[]{2, 2, 3, 4}, 2);
        run(new int[]{1, 2, 2, 3, 3, 3}, 3);
        run(new int[]{2, 2, 2, 3, 3}, -1);
        run(new int[]{5}, -1);
        run(new int[]{7, 7, 7, 7, 7, 7, 7}, 7);
    }

    public static void run(int[] nums, int correctAnswer) {
        Utils.printBreakLine();
        Utils.print("start app with: ", nums);
        int result = new Solution().findLucky(nums);
        System.out.println("result is: " + result);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        public int findLucky(int[] arr) {
            int[] lucky = new int[501];
            for (int i = 0; i <= 500; i++) {
                lucky[i] = 0;
            }

            for (int i = 0; i < arr.length; i++) {
                lucky[arr[i]]++;
            }

            for (int i = 500; i > 0; i--) {
                if (i == lucky[i]) return i;
            }

            return -1;
        }
    }
}
