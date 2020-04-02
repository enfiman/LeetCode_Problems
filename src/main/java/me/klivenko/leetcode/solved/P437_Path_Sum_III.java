package me.klivenko.leetcode.solved;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;
import me.klivenko.leetcode.common.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    You are given a binary tree in which each node contains an integer value.

    Find the number of paths that sum to a given value.

    The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

    The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

    Example:

    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

          10
         /  \
        5   -3
       / \    \
      3   2   11
     / \   \
    3  -2   1

    Return 3. The paths that sum to 8 are:

    1.  5 -> 3
    2.  5 -> 2 -> 1
    3. -3 -> 11
 */
public class P437_Path_Sum_III {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.left = new TreeNode(1);

        run(root, 8, 3);

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);
        run(root2, 1, 4);

    }

    public static void run(TreeNode root, int sum, int correctAnswer) {
        Utils.print("start app with: ", root);
        int result = new Solution().pathSum(root, sum);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        private int totalCount = 0;
        private int hasSum(List<Integer> path, int sum){
            int hasSum = 0;
            int subTotal = 0;
            for(int i = path.size() - 1; i >= 0; i--){
                subTotal += path.get(i);
                if(subTotal == sum) {
                    System.out.println(path);
                    hasSum++;
                }
            }

            return hasSum;
        }

        private void dfs(TreeNode root, int sum, List<Integer> path){
            if(null == root) return;

            path.add(root.val);

            totalCount += hasSum(path, sum);

            dfs(root.left, sum, path);
            dfs(root.right, sum, path);

            path.remove(path.size() - 1);
        }

        public int pathSum(TreeNode root, int sum) {
            dfs(root, sum, new ArrayList<>());

            return totalCount;
        }
    }
}
