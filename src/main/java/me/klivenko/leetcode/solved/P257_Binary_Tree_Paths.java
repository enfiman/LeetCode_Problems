package me.klivenko.leetcode.solved;


import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;
import me.klivenko.leetcode.common.model.TreeNode;

import java.util.*;

/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */

/*
    tags: dfs, recursion
 */

/*
    https://leetcode.com/problems/binary-tree-paths/
 */
public class P257_Binary_Tree_Paths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        List<String> output1 = Arrays.asList("1->2->5", "1->3");
        run(root, output1);
    }

    public static void run(TreeNode root, List<String> correctAnswer) {
        Utils.print("start app with: ", root);
        List<String> result = new Solution().binaryTreePaths(root);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        private void helper(TreeNode root, String path, List<String> list) {
            if (null == root.left && null == root.right) list.add(path + root.val);
            if (null != root.left) helper(root.left, path + root.val + "->", list);
            if (null != root.right) helper(root.right, path + root.val + "->", list);
        }

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if(root != null) helper(root, "", res);
            return res;
        }
    }
}
