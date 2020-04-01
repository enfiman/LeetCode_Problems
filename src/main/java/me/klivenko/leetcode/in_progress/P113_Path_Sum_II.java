package me.klivenko.leetcode.in_progress;

/*
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;
import me.klivenko.leetcode.common.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    https://leetcode.com/problems/path-sum-ii/
 */
public class P113_Path_Sum_II {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> result = Arrays.asList(
                Arrays.asList(5, 4, 11, 2),
                Arrays.asList(5, 8, 4, 5)
        );

        run(root, 22, result);
    }

    public static void run(TreeNode root, int sum, List<List<Integer>> correctAnswer) {
        Utils.print("start app with: ", root);
        List<List<Integer>> result = new Solution().pathSum(root, sum);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        private int sum(List<Integer> path) {
            int sum = 0;
            for (int i = 0; i < path.size(); i++) {
                sum += path.get(i);
            }
            return sum;
        }

        private void dfs(TreeNode root, int sum, List<Integer> path) {
            if (null == root) return;

            path.add(root.val);

            if (root.left == null && root.right == null && sum(path) == sum) {
                result.add(new ArrayList(path));
            } else {
                dfs(root.left, sum, path);
                dfs(root.right, sum, path);
            }

            path.remove(path.size() - 1);
        }

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            dfs(root, sum, new ArrayList<>());
            return result;
        }
    }
}
