package com.example;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(solution(new int[] { 4, 3, 2, 1 })));
        // System.out.println(Arrays.toString(solution(new int[] { 9 })));
        System.out.println(Arrays.toString(solution(new int[] { 8, 9, 9, 9 })));
    }

    public static int[] solution(int[] digits) {
        int end = digits.length - 1;
        int carry = 0;

        digits[end] += 1;

        for (int i = end; i >= 0; i--) {
            digits[i] += carry;

            digits[i] %= 10;
            carry = digits[i] / 10;
        }

        return digits;
    }
}