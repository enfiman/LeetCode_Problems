package me.klivenko.leetcode.top_interview_questions.medium.backtracking;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

/*
    https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/794/
 */
public class Generate_Parentheses {
    public static void main(String[] args) {
        run(3, Arrays.asList(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
        ));
    }

    public static void run(int n, List<String> correctAnswer) {
        Utils.print("start app with: ", n);
        List<String> result = new Solution().generateParenthesis(n);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        private List<String> result = new ArrayList<>();

        private void generate(int n, int left, int right, String s){
            if(n == left && n == right) {
                result.add(s);
                return;
            }

            if(left < n) {
                generate(n, left + 1, right, s + "(");
            }

            if(right < left) {
                generate(n, left, right + 1, s + ")");
            }
        }

        public List<String> generateParenthesis(int n) {
            generate(n, 0, 0, "");
            return result;
        }
    }
}
