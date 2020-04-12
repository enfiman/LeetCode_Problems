package me.klivenko.leetcode.contest.w184;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given an array of string words. Return all strings in words which is substring of another word in any order.

String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].



Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Example 2:

Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
Example 3:

Input: words = ["blue","green","bu"]
Output: []


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] contains only lowercase English letters.
It's guaranteed that words[i] will be unique.
 */

/*
https://leetcode.com/contest/weekly-contest-184/problems/string-matching-in-an-array/
 */
public class P1 {
    public static void main(String[] args) {
        run(new String[]{"mass", "as", "hero", "superhero"}, Arrays.asList("as", "hero"));

        run(new String[]{"leetcode", "et", "code"}, Arrays.asList("et", "code"));

        run(new String[]{"blue", "green", "bu"}, Arrays.asList());

        run(new String[]{"blue"}, Arrays.asList());
    }

    public static void run(String[] words, List<String> correctAnswer) {
        Utils.printBreakLine();
        Utils.print("start app with: ", Utils.convert(words));
        List<String> result = new Solution().stringMatching(words);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length; j++) {
                    String left = words[i];
                    String right = words[j];

                    if (i == j) continue;

                    if (left.contains(right)) {
                        if(!result.contains(right)) {
                            result.add(right);
                        }
                    }
                }
            }
            return result;
        }
    }
}
