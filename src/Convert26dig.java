package com.example;

public class Convert26dig {
    public static String convert(int number) {
        StringBuilder sb = new StringBuilder();

        int copy = number;
        int remain = 0;

        do {
            remain = copy % 26;
            copy = copy / 26;

            if (remain > 9) {
                sb.append((char) ('A' + remain - 10));
            } else {
                sb.append((char) ('0' + remain));
            }
        } while (copy > 0);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convert(25));
    }
}
