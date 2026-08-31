package com.example;

import java.util.Arrays;

public class Q482 {
    public static String licenseKeyFormatting(String s, int k) {
        char[] arr = s.toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '-') {
                continue;
            }

            if (count == k) {
                sb.append('-');
                count = 0;
            }

            sb.append(Character.toUpperCase(arr[i]));
            count++;
        }
        System.out.println(Arrays.toString(arr));
        return sb.reverse().toString();
    }

    public static String licenseKeyFormatting2(String s, int k) {
        char[] arr = s.toCharArray();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (c != '-') {
                num++;
            }
        }

        int len = num + num / k + (num % k == 0 ? -1 : 0);

        char[] result = new char[len];
        int count = 0, index = len - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '-') {
                continue;
            }

            if (count == k) {
                result[index--] = '-';
                count = 0;
            }

            result[index--] = arr[i] >= 97 ? (char) (arr[i] - 32) : arr[i];
            count++;
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting2("a-b-c-d-e", 2));
    }
}
