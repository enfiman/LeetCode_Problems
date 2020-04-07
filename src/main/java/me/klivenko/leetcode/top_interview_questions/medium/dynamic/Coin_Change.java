package me.klivenko.leetcode.top_interview_questions.medium.dynamic;

/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 */

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.Arrays;

/*
    https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/809/
 */
public class Coin_Change {

    public static void main(String[] args) {
        run(new int[]{1, 2, 5}, 11, 3);
        run(new int[]{2}, 3, -1);
        run(new int[]{1}, 0, 0);
        run(new int[]{2}, 1, -1);
        run(new int[]{1, 2147483647}, 2, 2);
    }

    public static void run(int[] coins, int amount, int correctAnswer) {
        Utils.print("start app with: ", Utils.convert(coins) + " " + amount);
        int result = new Solution().coinChange(coins, amount);
        Assert.equals(correctAnswer, result);
    }

    public static class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);

            for (int coin : coins) {
                if (coin <= amount) {
                    dp[coin] = 1;
                }
            }

            for (int i = 0; i < amount + 1; i++) {
                if (dp[i] == Integer.MAX_VALUE) continue;

                for (int coin : coins) {
                    if (coin > amount || i + coin > amount) continue;
                    dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                }
            }

            if (dp[amount] == Integer.MAX_VALUE) return -1;

            return dp[amount];
        }
    }
}
