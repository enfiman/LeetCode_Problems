package me.klivenko.leetcode.challenge.april_2020;

/*
Given an integer array arr, count element x such that x + 1 is also in arr.

If there're duplicates in arr, count them seperately.



Example 1:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
Example 2:

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
Example 3:

Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
Example 4:

Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.


Constraints:

1 <= arr.length <= 1000
0 <= arr[i] <= 1000
*/

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.*;

/*
    https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/
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
