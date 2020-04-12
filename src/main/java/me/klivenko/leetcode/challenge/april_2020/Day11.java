package me.klivenko.leetcode.challenge.april_2020;

import me.klivenko.leetcode.common.model.TreeNode;

/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
*/


/*
    https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3293/
 */
public class Day11 {
    public static class Solution {

        public int height(TreeNode node) {
            if (node == null) return 0;

            return (1 + Math.max(height(node.left), height(node.right)));
        }

        public int diameter(TreeNode root) {
            if (root == null) return 0;

            return Math.max(height(root.left) + height(root.right) + 1,
                    Math.max(diameter(root.left), diameter(root.right)));
        }

        public int diameterOfBinaryTree(TreeNode root) {
            if (null == root) return 0;

            return diameter(root) - 1;
        }
    }
}
