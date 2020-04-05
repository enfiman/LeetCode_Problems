package me.klivenko.leetcode.contest.w183;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/*
Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non included elements in such subsequence.

If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array.

Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order.



Example 1:

Input: nums = [4,3,10,9,8]
Output: [10,9]
Explanation: The subsequences [10,9] and [10,8] are minimal such that the sum of their elements is strictly greater than the sum of elements not included, however, the subsequence [10,9] has the maximum total sum of its elements.
Example 2:

Input: nums = [4,4,7,6,7]
Output: [7,7,6]
Explanation: The subsequence [7,7] has the sum of its elements equal to 14 which is not strictly greater than the sum of elements not included (14 = 4 + 4 + 6). Therefore, the subsequence [7,6,7] is the minimal satisfying the conditions. Note the subsequence has to returned in non-decreasing order.
Example 3:

Input: nums = [6]
Output: [6]


Constraints:

1 <= nums.length <= 500
1 <= nums[i] <= 100
 */

/*
5376. Minimum Subsequence in Non-Increasing Order
1403. Minimum Subsequence in Non-Increasing Order
 */

/*
    https://leetcode.com/contest/weekly-contest-183/problems/minimum-subsequence-in-non-increasing-order/
 */
public class P1_Minimum_Subsequence_in_Non_Increasing_Order {
    public static void main(String[] args) {
        run(new int[]{4,3,10,9,8}, Arrays.asList(10, 9));

        run(new int[]{4,3,2,9,10}, Arrays.asList(10, 9));

        run(new int[]{6}, Arrays.asList(6));

        run(new int[]{4,4,7,6,7}, Arrays.asList(7,7,6));

        run(new int[]{10,2,5}, Arrays.asList(10));

        run(new int[]{7,4,2,8,1,7,7,10}, Arrays.asList(10, 8, 7));
    }

    public static void run(int[] nums, List<Integer> correctAnswer) {
        Utils.printBreakLine();
        Utils.print("start app with: ", nums);
        List<Integer> result = new Solution().minSubsequence(nums);
        System.out.println("result is: " + result);
        Assert.equals(correctAnswer, result);
    }

    static class Solution {

        private int findSum(List<Integer> list, int start, int end){
            int sum = 0;
            for(int i = start; i <= end; i++){
                sum += list.get(i);
            }
            return sum;
        }

        private List<Integer> convertAndSort(int[] nums){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                list.add(nums[i]);
            }
            list.sort(Comparator.reverseOrder());
            return list;
        }

        public List<Integer> minSubsequence(int[] nums) {
            int totalSum = 0;
            for(int i = 0; i < nums.length; i++){
                totalSum += nums[i];
            }

            int startI = 0, startJ = 0;

            List<Integer> sorted = convertAndSort(nums);

            for(int i = 0; i < nums.length; i++){
                int sum = findSum(sorted, 0, i);
                if(sum * 2 > totalSum) {
                    startI = 0;
                    startJ = i;
                    break;
                }
            }

            List<Integer> list = new ArrayList<>();
            for(int i = startI; i <= startJ; i++){
                list.add(sorted.get(i));
            }

            list.sort(Comparator.reverseOrder());

            return list;
        }
    }
}
