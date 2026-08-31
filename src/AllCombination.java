package com.example;

import java.util.ArrayList;
import java.util.List;

public class AllCombination {
    public static List<String> allCombination(String str) {
        List<String> result = new ArrayList<>();
        helper(0, new StringBuilder(), str, result);
        return result;
    }

    private static void helper(int index, StringBuilder collect, String str, List<String> result) {
        if (index >= str.length()) {
            result.add(collect.toString());
            return;
        }

        collect.append(str.charAt(index));
        helper(index + 1, collect, str, result);
        collect.deleteCharAt(collect.length() - 1);
        helper(index + 1, collect, str, result);
    }

    public static void main(String[] args) {
        System.out.println(allCombination("abc"));
    }
}
