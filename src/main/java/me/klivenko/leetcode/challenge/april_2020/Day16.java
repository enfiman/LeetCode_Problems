package me.klivenko.leetcode.challenge.april_2020;

/*
 Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
*/


import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

/*
    https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/
 */
public class Day16 {
    public static void main(String[] args) {
        run("()", true);
        run("(*)", true);
        run("(*))", true);
    }

    public static void run(String s, boolean correctAnswer) {
        Utils.print("start app with: ", s);
        boolean result = new Solution().checkValidString(s);
        Assert.equals(correctAnswer, result);
    }

    public static class Solution {
        private boolean check(String s, int pos, int counter) {
            if (counter < 0) return false;

            if (pos == s.length()) {
                return counter == 0;
            }

            if (s.charAt(pos) == '*') {
                return check(s, pos + 1, counter + 1) ||
                        check(s, pos + 1, counter - 1) ||
                        check(s, pos + 1, counter);
            } else if (s.charAt(pos) == '(') {
                return check(s, pos + 1, counter + 1);
            } else if (s.charAt(pos) == ')') {
                return check(s, pos + 1, counter - 1);
            }
            return true;
        }

        public boolean checkValidString(String s) {
            return check(s, 0, 0);
        }
    }
}
