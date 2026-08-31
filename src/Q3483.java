package com.example;

public class Q3483 {
    public static int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        int[] total = new int[] { 0 };

        for (int digit : digits) {
            freq[digit]++;
        }

        helper(freq, 3, total);
        return total[0];
    }

    private static void helper(int[] freq, int k, int[] total) {
        if (k <= 0) {
            total[0]++;
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
            helper(freq, k - 1, total);
            freq[i]++;
        }
    }

    public static void main(String[] args) {
        System.out.println(totalNumbers(new int[] { 1, 2, 3 }));
    }
}
