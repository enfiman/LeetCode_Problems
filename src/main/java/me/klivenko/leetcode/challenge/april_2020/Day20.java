package me.klivenko.leetcode.challenge.april_2020;

import me.klivenko.leetcode.common.Utils;
import me.klivenko.leetcode.common.model.TreeNode;

/*
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)



Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]



Note:

1 <= preorder.length <= 100
The values of preorder are distinct.
 */

/*
    https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3305/
 */
public class Day20 {
    public static void main(String[] args) {
        run(new int[]{8, 5, 1, 7, 10, 12});
    }

    public static void run(int[] preorder) {
        Utils.print("start app with: ", Utils.convert(preorder));
        TreeNode result = new Solution().bstFromPreorder(preorder);
        System.out.println(result);
    }

    public static class Solution {

        int i = 0;

        private TreeNode helper(int[] preorder, int bound) {
            if (i >= preorder.length || preorder[i] > bound) return null;

            TreeNode treeNode = new TreeNode(preorder[i++]);
            treeNode.left = helper(preorder, treeNode.val);
            treeNode.right = helper(preorder, bound);

            return treeNode;
        }

        public TreeNode bstFromPreorder(int[] preorder) {
            return helper(preorder, Integer.MAX_VALUE);
        }
    }
}

