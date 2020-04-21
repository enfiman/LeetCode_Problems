package me.klivenko.leetcode.contest.w185;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.



Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.
Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.
Example 4:

Input: s = "covid2019"
Output: "c2o0v1i9d"
Example 5:

Input: s = "ab123"
Output: "1a2b3"


Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters and/or digits.
 */

/*
https://leetcode.com/contest/weekly-contest-185/problems/reformat-the-string/
 */
public class P1 {
    public static void main(String[] args) {
        run("a0b1c2", "0a1b2c");
        run("leetcode", "");
        run("1229857369", "");
        run("covid2019", "c2o0v1i9d");
        run("ab123", "1a2b3");
    }

    public static void run(String s, String correctAnswer) {
        Utils.printBreakLine();
        Utils.print("start app with: ", s);
        String result = new Solution().reformat(s);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        public String reformat(String s) {
            List<Character> digitList = new ArrayList();
            List<Character> charList = new ArrayList();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    digitList.add(c);
                } else {
                    charList.add(c);
                }
            }

            String result = "";
            if (Math.abs(digitList.size() - charList.size()) <= 1) {
                List<Character> bigger = charList.size() > digitList.size() ? charList : digitList;
                List<Character> lower = charList.size() <= digitList.size() ? charList : digitList;

                System.out.println(bigger);
                System.out.println(lower);

                for (int i = 0; i < lower.size(); i++) {
                    result += bigger.get(i) + "" + lower.get(i);
                }

                if (bigger.size() != lower.size()) {
                    result += bigger.get(bigger.size() - 1);
                }
            }

            return result;
        }
    }
}
