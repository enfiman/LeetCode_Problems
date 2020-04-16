package me.klivenko.leetcode.challenge.april_2020;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

direction can be 0 (for left shift) or 1 (for right shift).
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.



Example 1:

Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation:
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"
Example 2:

Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
Explanation:
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"


Constraints:

1 <= s.length <= 100
s only contains lower case English letters.
1 <= shift.length <= 100
shift[i].length == 2
0 <= shift[i][0] <= 1
0 <= shift[i][1] <= 100
*/


/*
    https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
 */
public class Day14 {
    public static void main(String[] args) {
        run("abc", new int[][]{{0, 1}, {1, 2}}, "cab");

        run("abcdefg", new int[][]{{1,1},{1,1},{0,2},{1,3}}, "efgabcd");


        run("mecsk", new int[][]{{1,4},{0,5},{0,4},{1,1},{1,5}}, "kmecs");


    }

    public static void run(String s, int[][] shift, String correctAnswer) {
        Utils.print("start app with: ", s + " " + Utils.convert(shift));
        String result = new Solution().stringShift(s, shift);
        Assert.equals(correctAnswer, result);
    }

    public static class Solution {

        public String stringShift(String s, int[][] shift) {
            int shiftDistance = 0;
            for (int i = 0; i < shift.length; i++) {
                shiftDistance += (shift[i][0] == 1) ? shift[i][1] * -1: shift[i][1];
            }

            if(Math.abs(shiftDistance) > s.length()) {
                if(shiftDistance < 0) {
                    shiftDistance %= s.length() * -1;
                }else{
                    shiftDistance %= s.length();
                }
            }

            if(shiftDistance < 0) shiftDistance = s.length() + shiftDistance;

            return s.substring(shiftDistance) + s.substring(0, shiftDistance);
        }
    }
}
