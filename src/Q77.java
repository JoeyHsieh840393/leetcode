package com.example;

import java.util.ArrayList;
import java.util.List;

public class Q77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private static void helper(int n, int k, int start, List<Integer> collect, List<List<Integer>> result) {
        if (k == collect.size()) {
            result.add(new ArrayList<>(collect));
            return;
        }

        for (int i = start; i <= n - (k - collect.size()) + 1; i++) {
            collect.add(i);
            helper(n, k, i + 1, collect, result);
            collect.remove(collect.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(20, 1));
    }
}
