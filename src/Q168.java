package com.example;

public class Q168 {
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        int copy = columnNumber;
        int remain = 0;

        while (copy > 0) {
            remain = copy % 26;
            copy /= 26;
            if (remain == 0) {

                remain = 26;
                copy--;
            }
            sb.append((char) ('A' + (remain - 1)));
        }

        System.out.println(sb.reverse().toString());
        return "";
    }

    public static void main(String[] args) {
        convertToTitle(2147483647);
    }
}
