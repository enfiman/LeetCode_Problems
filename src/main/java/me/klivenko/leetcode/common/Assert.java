package me.klivenko.leetcode.common;

public class Assert {
    public static void equals(String expected, String actual){
        if(expected.equals(actual)){
            printCorrect(actual);
            return;
        }

        printBad(expected, actual);
    }

    public static void equals(char[][] expected, char[][] actual){
        if(Utils.convert(expected).equals(Utils.convert(actual))){
            printCorrect(Utils.convert(actual).toString());
            return;
        }

        printBad(Utils.convert(actual).toString(), Utils.convert(expected).toString());
    }

    public static void equals(double expected, double actual){
        final double THRESHOLD = .0001;

        if (Math.abs(expected - actual) < THRESHOLD) {
            printCorrect(String.valueOf(actual));
            return;
        }

        printBad(String.valueOf(expected), String.valueOf(actual));
    }

    public static void equals(boolean expected, boolean actual){
        if (expected == actual) {
            printCorrect(String.valueOf(actual));
            return;
        }

        printBad(String.valueOf(expected), String.valueOf(actual));
    }

    public static void equals(int expected, int actual){
        if (expected == actual) {
            printCorrect(String.valueOf(actual));
            return;
        }

        printBad(String.valueOf(expected), String.valueOf(actual));
        throw new RuntimeException("Wrong answer!!!");
    }

    private static String printCorrect(String answer){
        String message = "Bingo! correct answer: " + answer;
        System.out.println(message);
        return message;
    }

    private static String printBad(String expected, String actual){
        String message = "Wrong answer! correct answers is: \n" + expected + "\n but your answer is:\n" + actual;
        System.out.println(message);
        return message;
    }
}
