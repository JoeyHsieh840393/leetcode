package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q2094 {
    public static int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();
        nonRepeatPermutation(digits, 3, new boolean[digits.length], 0, result);
        return result.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    private static void nonRepeatPermutation(int[] digits, int k, boolean[] selectedIndex, int collect,
            Set<Integer> result) {
        if (k <= 0) {
            result.add(collect);
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (selectedIndex[i]) {
                continue;
            }

            if (k == 3 && digits[i] == 0) {
                continue;
            }

            if (k == 1 && (digits[i] & 1) == 1) {
                continue;
            }

            collect = 10 * collect + digits[i];
            selectedIndex[i] = true;

            nonRepeatPermutation(digits, k - 1, selectedIndex, collect, result);

            selectedIndex[i] = false;
            collect /= 10;
        }
    }

    static int resultIndex = 0;

    public static int[] findEvenNumbers2(int[] digits) {
        int[] result = new int[450];
        int[] freq = new int[10];

        for (int d : digits) {
            freq[d]++;
        }

        helper(freq, 3, 0, result);
        return Arrays.copyOf(result, resultIndex);
    }

    private static void helper(int[] freq, int k, int collect, int[] result) {
        if (k <= 0) {
            result[resultIndex++] = collect;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (freq[i] == 0) {
                continue;
            }

            if (k == 3 && i == 0) {
                continue;
            }

            if (k == 1 && (i & 1) == 1) {
                continue;
            }

            freq[i]--;
            helper(freq, k - 1, collect * 10 + i, result);
            freq[i]++;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findEvenNumbers(new int[] { 2, 1, 3, 0 })));
        System.out.println(Arrays.toString(findEvenNumbers2(new int[] { 2, 2, 8, 8, 2 })));
    }
}
