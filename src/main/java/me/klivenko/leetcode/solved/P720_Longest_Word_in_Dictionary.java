package me.klivenko.leetcode.solved;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.HashSet;
import java.util.Set;

/*
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30]
 */


/*
https://leetcode.com/problems/longest-word-in-dictionary/
 */
public class P720_Longest_Word_in_Dictionary {
    public static void main(String[] args) {
        run(new String[]{"w", "wo", "wor", "worl", "world"}, "world");
        run(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}, "apple");
        run(new String[]{"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"}, "latte");

        run(new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"}, "yodn");

        run(new String[]{"ts","e","x","pbhj","opto","xhigy","erikz","pbh","opt","erikzb","eri","erik","xlye","xhig","optoj","optoje","xly","pb","xhi","x","o"}, "e");

    }

    public static void run(String[] words, String correctAnswer) {
        Utils.print("start app with: ", Utils.convert(words));
        String result = new Solution().longestWord(words);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        private String max = "";

        public String longestWord(String[] words) {
            Set<String> set = new HashSet();
            set.add("");
            for (String word : words) {
                set.add(word);
            }

            for (int i = 0; i < words.length; i++) {
                String subWord = words[i];

                for (int j = 0; j < subWord.length(); j++) {
                    if (!set.contains(subWord.substring(0, j))) {
                        break;
                    }

                    if (j == subWord.length() - 1) {
                        if (subWord.length() > max.length()) {
                            max = subWord;
                        } else if(subWord.length() == max.length() && max.compareTo(subWord) > 0) {
                            max = subWord;
                        }
                    }
                }
            }

            return max;
        }
    }
}
