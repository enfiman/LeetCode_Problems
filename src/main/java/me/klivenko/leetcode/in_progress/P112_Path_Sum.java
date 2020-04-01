package me.klivenko.leetcode.in_progress;

/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;
import me.klivenko.leetcode.common.model.TreeNode;
import me.klivenko.leetcode.solved.P257_Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    https://leetcode.com/problems/path-sum/
 */
public class P112_Path_Sum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        run(root, 22, true);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);

        run(root2, 1, false);
    }

    public static void run(TreeNode root, int sum, boolean correctAnswer) {
        Utils.print("start app with: ", root);
        boolean result = new Solution().hasPathSum(root, sum);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {

        private boolean dfs(TreeNode root, int currentSum, int sum){
            if(null == root) return false;

            currentSum = currentSum + root.val;

            if(currentSum == sum && root.left == null && root.right == null) {
                return true;
            }
            return dfs(root.left, currentSum, sum) || dfs(root.right, currentSum, sum);
        }

        public boolean hasPathSum(TreeNode root, int sum) {
            return dfs(root, 0, sum);
        }
    }
}
