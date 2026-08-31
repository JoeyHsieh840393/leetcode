package com.example;

public class Q541 {
    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i += 2 * k) {
            reverse(arr, i, Math.min(i + k - 1, arr.length - 1));
        }

        return new String(arr);
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);

            start++;
            end--;
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefgh", 3));
    }
}
