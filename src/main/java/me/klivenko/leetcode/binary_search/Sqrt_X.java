package me.klivenko.leetcode.binary_search;

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 */


/*
https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/
 */
public class Sqrt_X {
    public static void main(String[] args) {
        run(0, 0);
        run(1, 1);
        run(4, 2);
        run(8, 2);
        run(Integer.MAX_VALUE, (int)Math.sqrt(Integer.MAX_VALUE));
        run(2147302922, (int)Math.sqrt(Integer.MAX_VALUE) - 1);
    }

    public static void run(int x, int correctAnswer) {
        Utils.print("start app with: ", x);
        int result = new Solution().mySqrt(x);
        Assert.equals(correctAnswer, result);
    }

    public static class Solution {
        private int SQRT_OF_MAX = 46340;
        private int binarySearch(int left, int right, int target) {
            int center = (left + right) / 2;

            if(center == SQRT_OF_MAX) return center;
            int powCenter = center * center;
            int powCenterNext = (center + 1) * (center + 1);

            if(powCenter <= target && powCenterNext > target){
                return center;
            }

            if(powCenter > target){
                right = center;
            }else{
                left = center + 1;
            }
            return binarySearch(left, right, target);
        }

        public int mySqrt(int x) {
            return binarySearch(0, Math.min(x, SQRT_OF_MAX), x);
        }
    }
}
