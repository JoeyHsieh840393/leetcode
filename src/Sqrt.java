package com.example;

public class Sqrt {
    public static void main(String[] args) {
        System.out.printf("Sqrt(%d) = %d%n", 2147395600, solution(2147395600));
        // for (int i = 0; i < 100; i++) {
        // System.out.printf("Sqrt(%d) = %d%n", i, solution(i));
        // }
    }

    public static int solution(int x) {
        if (x < 2) {
            return x;
        }
        int start = x / 2;

        while (true) {
            int nextX = (start + x / start) / 2;

            if (nextX >= start) {
                break;
            }

            start = nextX;
        }

        return start;
    }
}
