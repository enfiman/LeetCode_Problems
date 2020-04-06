package me.klivenko.leetcode.top_interview_questions.medium.backtracking;

import com.sun.xml.internal.ws.api.message.HeaderList;
import me.klivenko.leetcode.common.Assert;
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

        run(new int[]{1, 2, 3}, Arrays.asList(
                new HashSet(Arrays.asList(3)),
                new HashSet(Arrays.asList(1)),
                new HashSet(Arrays.asList(2)),
                new HashSet(Arrays.asList(1, 3)),
                new HashSet(Arrays.asList(2, 3)),
                new HashSet(Arrays.asList(1, 2)),
                new HashSet(Arrays.asList(1, 2, 3))
        ));
    }

    public static void run(int[] nums, List<Set<Integer>> correctAnswer) {
        Utils.print("start app with: ", nums);
        List<List<Integer>> result = new Solution().subsets(nums);
        List<Set<Integer>> converted = new ArrayList();
        for (List<Integer> integers : result) {
            converted.add(new HashSet<>(integers));
        }
        Assert.equals(correctAnswer, converted);
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
                backTracking(nums, pos + 1, len, path);
                path.remove(path.size() - 1);
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            for(int i = 0; i < nums.length; i++){
                backTracking(nums, i, i + 1, new ArrayList<>());
            }

            return result;
        }
    }
}
