package me.klivenko.leetcode.contest.w183;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/*
Given a number s in their binary representation. Return the number of steps to reduce it to 1 under the following rules:

If the current number is even, you have to divide it by 2.

If the current number is odd, you have to add 1 to it.

It's guaranteed that you can always reach to one for all testcases.



Example 1:

Input: s = "1101"
Output: 6
Explanation: "1101" corressponds to number 13 in their decimal representation.
Step 1) 13 is odd, add 1 and obtain 14.
Step 2) 14 is even, divide by 2 and obtain 7.
Step 3) 7 is odd, add 1 and obtain 8.
Step 4) 8 is even, divide by 2 and obtain 4.
Step 5) 4 is even, divide by 2 and obtain 2.
Step 6) 2 is even, divide by 2 and obtain 1.
Example 2:

Input: s = "10"
Output: 1
Explanation: "10" corressponds to number 2 in their decimal representation.
Step 1) 2 is even, divide by 2 and obtain 1.
Example 3:

Input: s = "1"
Output: 0


Constraints:

1 <= s.length <= 500
s consists of characters '0' or '1'
s[0] == '1'
 */

/*
https://leetcode.com/contest/weekly-contest-183/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 */
public class P2_Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One {
    public static void main(String[] args) {
        run("1101", 6);
        run("10", 1);
        run("1", 0);
    }

    public static void run(String input, int correctAnswer) {
        Utils.printBreakLine();
        Utils.print("start app with: ", input);
        int result = new Solution().numSteps(input);
        System.out.println("result is: " + result);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        private String addBinary(String left) {
            String right = "1";
            String result = "";
            int s = 0;
            int i = left.length() - 1, j = right.length() - 1;
            while (i >= 0 || j >= 0 || s == 1) {
                s += ((i >= 0) ? left.charAt(i) - '0' : 0);
                s += ((j >= 0) ? right.charAt(j) - '0' : 0);
                result = (char) (s % 2 + '0') + result;
                s /= 2;
                i--;
                j--;
            }

            return result;
        }

        public int numSteps(String s) {
            int operations = 0;
            while (true) {
                if(s.equals("1")) break;
                char last = s.charAt(s.length() - 1);
                if (last == '1') {
                    s = addBinary(s);
                } else {
                    s = s.substring(0, s.length() - 1);
                }
                operations++;
            }

            return operations;
        }
    }
}
