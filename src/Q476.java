package com.example;

public class Q476 {
    public static int findComplement(int num) {
        int point = 1;

        while (num > point) {
            point = (point << 1) | 1;
        }
        return num ^ point;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(15));
    }
}
