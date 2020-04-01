package me.klivenko.leetcode.solved;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;
import me.klivenko.leetcode.common.model.TreeNode;
import me.klivenko.leetcode.solved.P257_Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given the root of a binary tree, each node has a value from 0 to 25 representing
the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

(As a reminder, any shorter prefix of a string is lexicographically smaller:
for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)

xample 1:



Input: [0,1,2,3,4,3,4]
Output: "dba"
Example 2:



Input: [25,1,3,1,3,0,2]
Output: "adz"
Example 3:



Input: [2,2,1,null,1,0,null,0]
Output: "abc"


Note:

The number of nodes in the given tree will be between 1 and 8500.
Each node in the tree will have a value between 0 and 25.

 */

/*
    https://leetcode.com/problems/smallest-string-starting-from-leaf/
 */
public class P988_Smallest_String_Starting_From_Leaf {
    public static void main(String[] args) {
        runTest3();
    }

    private static void runTest1(){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        run(root, "dba");
    }

    private static void runTest2(){
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);
        run(root, "adz");
    }

    private static void runTest3(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        run(root, "bae");
    }

    public static void run(TreeNode root, String correctAnswer) {
        Utils.print("start app with: ", root);
        String result = new Solution().smallestFromLeaf(root);
        System.out.println(result);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        private String ans = "~";

        public String smallestFromLeaf(TreeNode root) {
            dfs(root, new StringBuilder());
            return ans;
        }

        public void dfs(TreeNode node, StringBuilder sb) {
            if (node == null) return;
            sb.append((char)('a' + node.val));

            if (node.left == null && node.right == null) {
                sb.reverse();
                String s = sb.toString();
                sb.reverse();

                if (s.compareTo(ans) < 0) {
                    ans = s;
                }
            }

            dfs(node.left, sb);
            dfs(node.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
