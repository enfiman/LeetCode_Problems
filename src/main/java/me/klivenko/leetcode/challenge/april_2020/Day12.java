package me.klivenko.leetcode.challenge.april_2020;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;
import me.klivenko.leetcode.common.model.TreeNode;

import java.util.*;

/*
We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)



Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.


Note:

1 <= stones.length <= 30
1 <= stones[i] <= 1000
*/


/*
    https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3297/
 */
public class Day12 {
    public static void main(String[] args) {
        run(new int[]{2, 7, 4, 1, 8, 1}, 1);
        run(new int[]{1, 3}, 2);
        run(new int[]{2, 2}, 0);
    }

    public static void run(int[] arr, int correctAnswer) {
        Utils.print("start app with: ", arr);
        int result = new Solution().lastStoneWeight(arr);
        Assert.equals(correctAnswer, result);
    }

    public static class Solution {
        public int lastStoneWeight(int[] stones) {
            Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int stone : stones) {
                queue.add(stone);
            }

            while (queue.size() > 1) {
                int left = queue.poll();
                int right = queue.poll();

                if (left > right) {
                    queue.add(left - right);
                }
            }

            if (queue.isEmpty()) return 0;
            return queue.poll();
        }
    }
}
