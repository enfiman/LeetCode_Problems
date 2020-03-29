package me.klivenko.leetcode.solved;

import javafx.util.Pair;
import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.
*/

/*
    https://leetcode.com/problems/jump-game-ii/
 */
public class P45_Jump_Game_II {
    public static void main(String[] args) {
        run(new int[]{2, 3, 1, 1, 4}, 2);
    }

    public static void run(int[] nums, int correctAnswer) {
        Utils.print("start app with: ", nums);
        int result = new Solution().jump(nums);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        public int jump(int[] nums) {
            boolean[] visited = new boolean[nums.length];

            Queue<Pair<Integer, Integer>> queue = new LinkedList();
            queue.add(new Pair(0, 0));
            visited[0] = true;

            while (true) {
                Pair<Integer, Integer> pair = queue.poll();
                if (null == pair) return -1;
                int index = pair.getKey();

                if (index == nums.length - 1) return pair.getValue();

                int maxIndexVal = nums[index];
                if (maxIndexVal == 0) continue;

                for (int i = maxIndexVal; i >= 1; i--) {
                    int newIndex = index + i;
                    if (newIndex >= nums.length) {
                        continue;
                    }
                    if (visited[newIndex]) continue;

                    visited[newIndex] = true;
                    queue.add(new Pair(newIndex, pair.getValue() + 1));
                }
            }
        }
    }
}


