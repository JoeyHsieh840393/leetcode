package com.example;

import java.util.ArrayList;
import java.util.List;

public class CombinationWithString {
    public static List<String> nonRepeat(char[] chars, int k) {
        List<String> result = new ArrayList<>();
        nonRepeatHelper(chars, k, 0, new StringBuilder(), result);
        return result;
    }

    public static List<String> repeat(char[] chars, int k) {
        List<String> result = new ArrayList<>();
        repeatHelper(chars, k, 0, new StringBuilder(), result);
        return result;
    }

    private static void repeatHelper(char[] chars, int k, int start, StringBuilder collect, List<String> result) {
        if (collect.length() == k) {
            result.add(collect.toString());
            return;
        }
        for (int i = start; i < chars.length; i++) {
            collect.append(chars[i]);
            repeatHelper(chars, k, i, collect, result);
            collect.deleteCharAt(collect.length() - 1);
        }
    }

    private static void nonRepeatHelper(char[] chars, int k, int start, StringBuilder collect, List<String> result) {
        if (collect.length() == k) {
            result.add(collect.toString());
            return;
        }

        for (int i = start; i <= chars.length - (k - collect.length()); i++) {
            collect.append(chars[i]);
            nonRepeatHelper(chars, k, i + 1, collect, result);
            collect.deleteCharAt(collect.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(nonRepeat("1234".toCharArray(), 3));
    }
}
