package me.klivenko.leetcode.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static void printBreakLine(){
        System.out.println("-------------------------------------------------------------");
    }

    public static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void print(String messageBefore, int[][] arr){
        print(messageBefore, convert(arr));
    }

    public static void print(int[][] arr, String messageAfter){
        print(convert(arr), messageAfter);
    }

    public static void print(String messageBefore, int[][] arr, String messageAfter){
        print(messageBefore, convert(arr), messageAfter);
    }

    public static void print(String messageBefore, char[][] arr){
        print(messageBefore, convert(arr));
    }

    public static void print(char[][] arr, String messageAfter){
        print(convert(arr), messageAfter);
    }

    public static void print(String messageBefore, char[][] arr, String messageAfter){
        print(messageBefore, convert(arr), messageAfter);
    }

    public static void print(String messageBefore, char[] arr){
        print(messageBefore, convert(arr));
    }

    public static void print(char[] arr, String messageAfter){
        print(convert(arr), messageAfter);
    }

    public static void print(String messageBefore, char[] arr, String messageAfter){
        print(messageBefore, convert(arr), messageAfter);
    }

    public static void print(String messageBefore, int[] arr){
        print(messageBefore, convert(arr));
    }

    public static void print(int[] arr, String messageAfter){
        print(convert(arr), messageAfter);
    }

    public static void print(String messageBefore, int[] arr, String messageAfter){
        print(messageBefore, convert(arr), messageAfter);
    }

    public static void print(String messageBefore, Object obj){
        System.out.print(messageBefore);
        System.out.println(obj);
    }

    public static void print(Object obj, String messageAfter){
        System.out.println(obj);
        System.out.print(messageAfter);
    }

    public static void print(String messageBefore, Object obj, String messageAfter){
        System.out.print(messageBefore);
        System.out.println(obj);
        System.out.print(messageAfter);
    }


    public static List<Integer> convert(int[] array){
        List<Integer> list = new ArrayList();
        for(int i = 0; i < array.length; i++){
            list.add(array[i]);
        }
        return list;
    }

    public static List<List<Integer>> convert(int[][] array2d){
        List<List<Integer>> list2d = new ArrayList();
        for(int i = 0; i < array2d.length; i++){
            list2d.add(convert(array2d[i]));
        }
        return list2d;
    }


    public static List<String> convert(String[] array){
        return Arrays.asList(array);
    }

    public static List<Character> convert(char[] array){
        List<Character> list = new ArrayList<Character>();
        for(int i = 0; i < array.length; i++){
            list.add(array[i]);
        }
        return list;
    }

    public static List<List<String>> convert(String[][] array2d){
        List<List<String>> list2d = new ArrayList(array2d.length);
        for(int i = 0; i < array2d.length; i++){
            list2d.add(convert(array2d[i]));
        }
        return list2d;
    }

    public static List<List<Character>> convert(char[][] array2d){
        List<List<Character>> list2d = new ArrayList(array2d.length);
        for(int i = 0; i < array2d.length; i++){
            list2d.add(convert(array2d[i]));
        }
        return list2d;
    }

}
