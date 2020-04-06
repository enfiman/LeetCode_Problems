package me.klivenko.leetcode.top_interview_questions.medium.backtracking;

import me.klivenko.leetcode.common.Utils;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {

        /*
        [1 2 3]
        1
        2
        3
        1 2
        1 3
        2 3
        1 2 3
         */

        run(new int[]{1, 2, 3});
    }

    public static void run(int[] nums) {
        Utils.print("start app with: ", nums);
        List<List<Integer>> result = new Solution().subsets(nums);
        System.out.println(result);
    }

    static class Solution {

        private List<List<Integer>> result = new ArrayList<>();

        private void backTracking(int[] nums, int pos, int len, List<Integer> path){
            if(path.size() == len) {
                result.add(new ArrayList<>(path));
                return;
            }

            for(int i = pos; i < nums.length; i++){
                path.add(nums[i]);
                backTracking(nums, i + 1, len, path);
                path.remove(path.size() - 1);
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            for(int i = 0; i < nums.length + 1; i++){
                backTracking(nums, 0, i, new ArrayList<>());
            }
            return result;
        }
    }

    static class Solution_BitMask {
        private List<Integer> calc(int[] nums, int p){
            String s = Integer.toBinaryString(p);

            while(s.length() != nums.length){
                s = "0" + s;
            }

            List<Integer> result = new ArrayList<>();

            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1') result.add(nums[nums.length - 1 - i]);
            }
            return result;
        }

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            for(int i = 0; i < (int)Math.pow(2, nums.length); i++){
                result.add(calc(nums, i));
            }

            return result;
        }
    }
}
