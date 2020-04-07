package me.klivenko.leetcode.top_interview_questions.medium.other;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */

import me.klivenko.leetcode.common.Assert;
import me.klivenko.leetcode.common.Utils;

import java.util.*;

/*
    https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/823/
 */
public class Evaluate_Reverse_Polish_Notation {
    public static void main(String[] args) {
        run(new String[]{"2", "1", "+", "3", "*"}, 9);
        run(new String[]{"4", "13", "5", "/", "+"}, 6);
        run(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22);

    }

    public static void run(String[] tokens, int correctAnswer) {
        long start = System.currentTimeMillis();

        Utils.print("start app with: ", tokens);
        int result = new Solution().evalRPN(tokens);
        Assert.equals(correctAnswer, result);
        System.out.println((System.currentTimeMillis() - start));
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i < tokens.length; i++){
                String t = tokens[i];

                if("/*+-".contains(t)){
                    int right = stack.pop();
                    int left = stack.pop();
                    switch (t){
                        case "+":
                            stack.push(left + right);
                            break;
                        case "-":
                            stack.push(left - right);
                            break;
                        case "*":
                            stack.push(left * right);
                            break;
                        case "/":
                            stack.push(left / right);
                            break;
                    }
                }else {
                    stack.push(Integer.parseInt(t));
                }
            }
            return stack.pop();
        }
    }
}
