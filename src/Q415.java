package com.example;

import java.util.Arrays;

public class Q415 {
    public static String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        int size1 = arr1.length - 1;
        int size2 = arr2.length - 1;
        int size3 = Math.max(arr1.length, arr2.length);

        char[] arr3 = new char[size3 + 1];

        int carry = 0;
        while (size1 >= 0 || size2 >= 0 || carry == 1) {
            int d1 = (size1 >= 0) ? arr1[size1--] - '0' : 0;
            int d2 = (size2 >= 0) ? arr2[size2--] - '0' : 0;

            int sum = d1 + d2 + carry;

            carry = sum / 10;
            sum %= 10;

            arr3[size3--] = (char) (sum + '0');
        }

        if (arr3[0] == 0) {
            arr3 = Arrays.copyOfRange(arr3, 1, arr3.length);
        }

        return new String(arr3);
    }

    public static void main(String[] args) {
        System.out.println(addStrings("123", "1"));

    }
}
