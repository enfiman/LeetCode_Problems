package me.klivenko.leetcode.contest.w184;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
HTML entity parser is the parser that takes HTML code as input and replace all the entities of the special characters by the characters itself.

The special characters and their entities for HTML are:

Quotation Mark: the entity is &quot; and symbol character is ".
Single Quote Mark: the entity is &apos; and symbol character is '.
Ampersand: the entity is &amp; and symbol character is &.
Greater Than Sign: the entity is &gt; and symbol character is >.
Less Than Sign: the entity is &lt; and symbol character is <.
Slash: the entity is &frasl; and symbol character is /.
Given the input text string to the HTML parser, you have to implement the entity parser.

Return the text after replacing the entities by the special characters.



Example 1:

Input: text = "&amp; is an HTML entity but &ambassador; is not."
Output: "& is an HTML entity but &ambassador; is not."
Explanation: The parser will replace the &amp; entity by &
Example 2:

Input: text = "and I quote: &quot;...&quot;"
Output: "and I quote: \"...\""
Example 3:

Input: text = "Stay home! Practice on Leetcode :)"
Output: "Stay home! Practice on Leetcode :)"
Example 4:

Input: text = "x &gt; y &amp;&amp; x &lt; y is always false"
Output: "x > y && x < y is always false"
Example 5:

Input: text = "leetcode.com&frasl;problemset&frasl;all"
Output: "leetcode.com/problemset/all"


Constraints:

1 <= text.length <= 10^5
The string may contain any possible characters out of all the 256 ASCII characters.
 */

/*
https://leetcode.com/contest/weekly-contest-184/problems/html-entity-parser/
 */
public class P3 {
    public static void main(String[] args) {
        run("&amp; is an HTML entity but &ambassador; is not.", "& is an HTML entity but &ambassador; is not.");

        run("and I quote: &quot;...&quot;", "and I quote: \"...\"");

        run("Stay home! Practice on Leetcode :)", "Stay home! Practice on Leetcode :)");

        run("x &gt; y &amp;&amp; x &lt; y is always false", "x > y && x < y is always false");
        run("leetcode.com&frasl;problemset&frasl;all", "leetcode.com/problemset/all");

    }

    public static void run(String html, String correctAnswer) {
        Utils.printBreakLine();
        Utils.print("start app with: ", html);
        String result = new Solution().entityParser(html);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {

        private Map<String, String> replace = new HashMap();

        private void fillMap(){
            replace.put("&quot;", "\"");
            replace.put("&apos;", "'");
            replace.put("&amp;", "&");
            replace.put("&gt;", ">");
            replace.put("&lt;", "<");
            replace.put("&frasl;", "/");
        }

        public String entityParser(String text) {
            fillMap();

            for (Map.Entry<String, String> entry : replace.entrySet()) {
                text = text.replaceAll(entry.getKey(), entry.getValue());
            }

            return text;
        }
    }
}
