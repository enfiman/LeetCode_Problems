package me.klivenko.leetcode.challenge.april_2020;

/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.*;

/*
    https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3288/
 */
public class Day7 {
    public static void main(String[] args) {
        run(new int[]{1, 2, 3}, 2);
        run(new int[]{1, 1, 3, 3, 5, 5, 7, 7}, 0);
        run(new int[]{1, 3, 2, 3, 5, 0}, 3);
        run(new int[]{1, 1, 2, 2}, 2);
    }

    public static void run(int[] arr, int correctAnswer) {
        Utils.print("start app with: ", arr);
        int result = new Solution().countElements(arr);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        public int countElements(int[] arr) {
            int counter = 0;
            int[] existArray = new int[1001];
            Arrays.fill(existArray, 0);

            for (int i = 0; i < arr.length; i++) {
                existArray[arr[i]]++;
            }

            for (int i = 0; i < 1000; i++) {
                if (existArray[i] > 0 && existArray[i + 1] > 0) {
                    counter += existArray[i];
                }
            }

            return counter;
        }
    }
}
