package com.example;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithDigits {
    public static List<Integer> nonRepeat(int[] digits, int k) {
        List<Integer> result = new ArrayList<>();
        nonRepeatHelper(digits, k, 0, new boolean[digits.length], 0, result);
        return result;
    }

    public static List<Integer> repeat(int[] digits, int k) {
        List<Integer> result = new ArrayList<>();
        repeatHelper(digits, k, 0, 0, result);
        return result;
    }

    private static void repeatHelper(int[] digits, int k, int selectedCount, int collect,
            List<Integer> result) {
        if (k == selectedCount) {
            result.add(collect);
            return;
        }

        for (int i = 0; i < digits.length; i++) {

            if (selectedCount == 0 && digits[i] == 0) {
                continue;
            }

            collect = 10 * collect + digits[i];
            repeatHelper(digits, k, selectedCount + 1, collect, result);
            collect /= 10;
        }
    }

    private static void nonRepeatHelper(int[] digits, int k, int selectedCount, boolean[] selectedIndex, int collect,
            List<Integer> result) {
        if (k == selectedCount) {
            result.add(collect);
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (selectedIndex[i]) {
                continue;
            }

            if (selectedCount == 0 && digits[i] == 0) {
                continue;
            }

            collect = 10 * collect + digits[i];
            selectedIndex[i] = true;
            nonRepeatHelper(digits, k, selectedCount + 1, selectedIndex, collect, result);

            collect /= 10;
            selectedIndex[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(repeat(new int[] { 0, 1, 2, 3 }, 3));
        System.out.println(nonRepeat(new int[] { 0, 1, 2, 3 }, 3));
    }
}
