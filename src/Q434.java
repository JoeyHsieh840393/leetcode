package com.example;

public class Q434 {
    public static int countSegments(String s) {
        char[] arr = s.toCharArray();
        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != ' ' && arr[i + 1] == ' ') {
                count++;
            }
        }

        if (arr[arr.length - 1] != ' ') {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("  Hello  a   "));
        System.out.println(countSegments("  "));
        // System.out.println(countSegments(""));
    }
}
