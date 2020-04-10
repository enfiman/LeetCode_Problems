package me.klivenko.leetcode.binary_search;

/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example :

Input: n = 10, pick = 6
Output: 6
 */

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

/*
    https://leetcode.com/explore/learn/card/binary-search/125/template-i/951/
 */
public class Guess_Number_Higher_or_Lower {
    public static int correctAnswer = 0;

    public static void main(String[] args) {
        run(10, 6);
        run(100000, 6);
        run(2126753390,1702766719);
    }

    public static void run(int n, int correctAnswer) {
        Utils.print("start app with: ", n);
        Guess_Number_Higher_or_Lower.correctAnswer = correctAnswer;
        int result = new Solution().guessNumber(n);
        Assert.equals(correctAnswer, result);
    }

    public static class GuessGame {
        public static int guess(int num) {
            if(num < correctAnswer) return 1;
            if(num > correctAnswer) return -1;
            return 0;
        }
    }

    public static class Solution extends GuessGame {
        public int guessNumber(int n) {
            int left = 1, right = n, center;
            while(true) {
                center = (int)(left / 2 + right / 2);

                System.out.println(left + " " + center + " " + right);

                if(left == right) return left;
                int answer = guess(center);
                System.out.println(answer);
                if(answer == 0) return center;
                if(answer < 0) right = center;
                if(answer > 0) left = center + 1;
            }
        }
    }
}
