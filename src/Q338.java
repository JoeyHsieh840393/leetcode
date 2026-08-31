package com.example;

public class Q338 {
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 1; i < (n + 1); i++) {
            result[i] = result[i >> 1] + (i & i);
        }
        return result;
    }
}
