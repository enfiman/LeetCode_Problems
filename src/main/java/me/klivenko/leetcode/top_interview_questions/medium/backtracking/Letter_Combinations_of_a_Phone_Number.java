package me.klivenko.leetcode.top_interview_questions.medium.backtracking;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

/*
    https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Letter_Combinations_of_a_Phone_Number {

    public static void main(String[] args) {
        run("23", Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));

        run("", Arrays.asList());
    }

    public static void run(String digits, List<String> correctAnswer) {
        Utils.print("start app with: ", digits);
        List<String> result = new Solution().letterCombinations(digits);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {

        String[] letters = new String[]{
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"};

        List<String> result = new ArrayList<>();

        private void dfs(String digits, char[] combinations, int pos){
            if(digits.length() == pos) {
                if(pos != 0){
                    result.add(new String(combinations));
                }
                return;
            }

            int dig = digits.charAt(pos) - '0';
            String chars = letters[dig];

            for(int i = 0; i < chars.length(); i++){
                combinations[pos] = chars.charAt(i);
                dfs(digits, combinations, pos + 1);
            }
        }

        public List<String> letterCombinations(String digits) {
            dfs(digits, new char[digits.length()], 0);
            return result;
        }
    }
}
