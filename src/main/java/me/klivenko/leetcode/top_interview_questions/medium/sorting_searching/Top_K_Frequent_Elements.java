package me.klivenko.leetcode.top_interview_questions.medium.sorting_searching;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.*;

/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 */

/*
https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/799/
 */
public class Top_K_Frequent_Elements {
    public static void main(String[] args) {
        run(new int[]{1, 1, 1, 2, 2, 3}, 2, Arrays.asList(1,2));
        run(new int[]{1}, 1, Arrays.asList(1));
    }

    public static void run(int[] nums, int k, List<Integer> correctAnswer) {
        Utils.print("start app with: ", nums);
        List<Integer> result = new Solution().topKFrequent(nums, k);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequentMap = new HashMap();
            for (int num : nums) {
                frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Integer> frequentKElements = new PriorityQueue<>(k,
                    Comparator.comparing(frequentMap::get));

            for (Integer key : frequentMap.keySet()) {
                frequentKElements.add(key);

                if(frequentKElements.size() > k) {
                    frequentKElements.poll();
                }
            }

            List<Integer> result = new ArrayList<>();
            for(int i = 0; i < k; i++) {
                result.add(frequentKElements.poll());
            }
            Collections.reverse(result);

            return result;
        }
    }
}
