package com.example;

public class Q231 {
    public static boolean isPowerOfTwo(int n) {
        int nums = Math.abs(n);

        while (nums % 2 == 0) {
            nums /= 2;
        }

        return nums == 1;
    }
}
