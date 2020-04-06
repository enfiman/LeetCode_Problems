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
public class Day6 {
    public static void main(String[] args) {
        run(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                Arrays.asList(
                    Arrays.asList("ate", "eat", "tea"),
                    Arrays.asList("nat", "tan"),
                    Arrays.asList("bat")
                )
        );
    }

    public static void run(String[] input, List<List<String>> correctAnswer) {
        Utils.print("start app with: ", input);
        List<List<String>> result = new Solution().groupAnagrams(input);

      //  Assert.equals(correctAnswer, result);
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> anagramsMap = new HashMap();
            List<List<String>> response = new ArrayList<>();

            for(int i = 0; i < strs.length; i++){
                char[] charArray = strs[i].toCharArray();
                Arrays.sort(charArray);
                String sorted = new String(charArray);

                if(null == anagramsMap.get(sorted)){
                    List<String> raw = new ArrayList<>();
                    response.add(raw);
                    anagramsMap.put(sorted, raw);
                }
                anagramsMap.get(sorted).add(strs[i]);
            }

            return response;
        }
    }
}
