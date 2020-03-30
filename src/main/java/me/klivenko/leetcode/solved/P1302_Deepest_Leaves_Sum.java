package me.klivenko.leetcode.solved;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;
import me.klivenko.leetcode.common.model.TreeNode;

public class P1302_Deepest_Leaves_Sum {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(6);
        node.left.left.left = new TreeNode(7);
        node.right.right.right = new TreeNode(8);

        run(node, 15);
    }

    public static void run(TreeNode root, int correctAnswer) {
        Utils.printBreakLine();
        Utils.print("start app with: ", root);

        int result = new Solution().deepestLeavesSum(root);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        public int deepestLeavesSum(TreeNode root) {
            int maxLevel = findMaxLevelNode(root, 0);
            int sum = calcSumAtLevel(root, 0, 0, maxLevel);

            return sum;
        }

        public int calcSumAtLevel(TreeNode root, int currentLevel, int sum, int levelForCalculation){
            if(null == root) return sum;

            if(currentLevel == levelForCalculation) {
                sum += root.val;
                return sum;
            }

            sum = calcSumAtLevel(root.left, currentLevel + 1, sum, levelForCalculation);
            sum = calcSumAtLevel(root.right, currentLevel + 1, sum, levelForCalculation);

            return sum;
        }

        public int findMaxLevelNode(TreeNode root, int level){
            if(null == root) return level - 1;

            int leftLevel = findMaxLevelNode(root.left, level + 1);
            int rightLevel = findMaxLevelNode(root.right, level + 1);

            return Math.max(leftLevel, rightLevel);
        }
    }
}
