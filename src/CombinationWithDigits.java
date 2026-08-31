package com.example;

import java.util.ArrayList;
import java.util.List;

public class CombinationWithDigits {
    public static List<Integer> nonRepeat(int[] digits, int k) {
        List<Integer> result = new ArrayList<>();
        nonRepeatHelper(digits, k, 0, 0, 0, result);
        return result;
    }

    public static List<Integer> repeat(int[] digits, int k) {
        List<Integer> result = new ArrayList<>();
        repeatHelper(digits, k, 0, 0, 0, result);
        return result;

    }

    private static void repeatHelper(int[] digits, int k, int selectedCount, int start, Integer collect,
            List<Integer> result) {
        if (k == selectedCount) {
            result.add(collect);
            return;
        }

        for (int i = start; i < digits.length; i++) {
            collect = 10 * collect + digits[i];
            repeatHelper(digits, k, selectedCount + 1, i, collect, result);
            collect /= 10;
        }
    }

    private static void nonRepeatHelper(int[] digits, int k, int selectedCount, int start, Integer collect,
            List<Integer> result) {
        if (k == selectedCount) {
            result.add(collect);
            return;
        }

        for (int i = start; i <= digits.length - (k - selectedCount); i++) {
            collect = 10 * collect + digits[i];
            nonRepeatHelper(digits, k, selectedCount + 1, i + 1, collect, result);
            collect /= 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(nonRepeat(new int[] { 1, 2, 3, 4 }, 3));
        System.out.println(repeat(new int[] { 1, 2, 3 }, 2));
    }
}
