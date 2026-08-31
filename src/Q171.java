package com.example;

public class Q171 {
    public static int titleToNumber(String columnTitle) {
        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            sum = sum * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
