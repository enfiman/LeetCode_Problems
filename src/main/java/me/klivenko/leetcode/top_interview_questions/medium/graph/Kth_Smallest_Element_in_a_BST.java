package me.klivenko.leetcode.top_interview_questions.medium.graph;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;
import me.klivenko.leetcode.common.model.TreeNode;

/*
/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */

/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class Kth_Smallest_Element_in_a_BST {

    public static void main(String[] args) {
        run1();
        run2();
    }

    public static void run1(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        run(root, 1, 1);

    }

    public static void run2(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);
        run(root, 3, 3);
    }

    public static void run(TreeNode treeNode, int k, int correctAnswer) {
        Utils.print("start app with: ", treeNode);
        int result = new Solution().kthSmallest(treeNode, k);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        int result = 0;
        int globalCounter = 0;
        private void dfs(TreeNode root, int k){
            if(root == null) return;

            dfs(root.left, k);
            globalCounter ++;
            if(k == globalCounter) result = root.val;
            dfs(root.right, k);

        }

        public int kthSmallest(TreeNode root, int k) {
            dfs(root, k);

            return result;
        }
    }
}
