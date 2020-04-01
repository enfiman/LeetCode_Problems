package me.klivenko.leetcode.solved;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;
import me.klivenko.leetcode.common.model.TreeNode;

/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */

/*
    tags: dfs, recursion
 */

/*
    https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class P129_Sum_Root_to_Leaf_Numbers {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        run(root1, 25);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(0);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(1);
        run(root2, 1026);
    }

    public static void run(TreeNode root, int correctAnswer) {
        Utils.print("start app with: ", root);
        int result = new Solution().sumNumbers(root);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        int totalSum = 0;

        public void dfs(TreeNode root, int sum){
            if(root == null) return;

            if(root.left == null && root.right == null) {
                totalSum += sum * 10 + root.val;
                return;
            }

            dfs(root.left, sum * 10 + root.val);
            dfs(root.right, sum * 10 + root.val);
        }

        public int sumNumbers(TreeNode root) {
            dfs(root, 0);
            return totalSum;
        }
    }
}
