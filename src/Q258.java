package com.example;

public class Q258 {
    public static int addDigits(int num) {
        while (num > 9) {
            int sum = 0;

            while (num > 0) {
                int r = num % 10;

                sum += r;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(37 & 1);
    }
}
