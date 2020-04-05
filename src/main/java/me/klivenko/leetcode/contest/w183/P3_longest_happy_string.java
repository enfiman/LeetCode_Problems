package me.klivenko.leetcode.contest.w183;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.*;

/*
A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.

Given three integers a, b and c, return any string s, which satisfies following conditions:

s is happy and longest possible.
s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
s will only contain 'a', 'b' and 'c' letters.
If there is no such string s return the empty string "".



Example 1:

Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.
Example 2:

Input: a = 2, b = 2, c = 1
Output: "aabbc"
Example 3:

Input: a = 7, b = 1, c = 0
Output: "aabaa"
Explanation: It's the only correct answer in this case.


Constraints:

0 <= a, b, c <= 100
a + b + c > 0
 */

/*
https://leetcode.com/contest/weekly-contest-183/problems/longest-happy-string/
 */
public class P3_longest_happy_string {
    public static void main(String[] args) {
        run(1, 1, 7, "ccaccbcc");
    }

    public static void run(int a, int b, int c, String correctAnswer) {
        Utils.printBreakLine();
        String result = new Solution().longestDiverseString(a, b, c);
        System.out.println("result is: " + result);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        private Map<String, Integer> map = new HashMap();
        private List<String> priorityList = new ArrayList();
        private StringBuilder result = new StringBuilder();
        private Comparator<String> comparator = (o1, o2) -> map.get(o2).compareTo(map.get(o1));

        public void add(String s) {
            int counter = 1;
            result.append(s);
            if (!result.toString().endsWith(s)) {
                counter++;
                result.append(s);
            }
            map.put(s, map.get(s) - counter);
        }

        public boolean canAdd(String s) {
            return !result.toString().endsWith(s.concat(s));
        }

        private void sort() {
            priorityList.sort(comparator);

            if (map.get(priorityList.get(priorityList.size() - 1)) == 0) {
                priorityList.remove(priorityList.size() - 1);
            }
        }

        public String longestDiverseString(int a, int b, int c) {
            if (a > 0) map.put("a", a);
            if (b > 0) map.put("b", b);
            if (c > 0) map.put("c", c);

            priorityList.addAll(map.keySet());

            while (true) {
                sort();
                if (priorityList.size() >= 1 && canAdd(priorityList.get(0))) {
                    add(priorityList.get(0));
                } else if (priorityList.size() >= 2 && canAdd(priorityList.get(1))) {
                    add(priorityList.get(1));
                } else {
                    break;
                }
            }

            return result.toString();
        }
    }
}

