package me.klivenko.leetcode.top_interview_questions.medium.backtracking;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

/*
    https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/795/
 */
public class Permutations {
    public static void main(String[] args) {
        run(new int[]{1, 2, 3}, Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1)
        ));

        run(new int[]{1}, Arrays.asList(
                Arrays.asList(1)
        ));

        run(new int[]{}, Arrays.asList(
        ));
    }

    public static void run(int[] nums, List<List<Integer>> correctAnswer) {
        Utils.print("start app with: ", nums);
        List<List<Integer>> result = new Solution().permute(nums);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        private void recursion(int[] nums, int currentPosition, boolean[] usage,
                               List<Integer> permute, List<List<Integer>> allPermutes){
            if(currentPosition == nums.length) {
                allPermutes.add(new ArrayList<>(permute));
                return;
            }

            for(int i = 0; i < nums.length; i++){
                if(usage[i]) {
                    continue;
                }
                usage[i] = true;
                permute.add(nums[i]);
                recursion(nums, currentPosition + 1, usage, permute, allPermutes);
                usage[i] = false;
                permute.remove(permute.size() - 1);
            }
        }

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if(nums.length == 0) return result;

            boolean[] usage = new boolean[nums.length];
            for(int i = 0; i < usage.length; i++) {
                usage[i] = false;
            }

            recursion(nums, 0, usage, new ArrayList<>(), result);
            return result;
        }
    }
}
