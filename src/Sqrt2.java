package com.example;

public class Sqrt2 {
    public static void main(String[] args) {
        System.out.printf("Sqrt(%d) = %d%n", 2147395600, solution(2147395600));
        // for (int i = 1000; i < 10000; i++) {
            // System.out.printf("Sqrt(%d) = %d%n", i, solution(i));
        // }
    }

    public static int solution(int x) {
        if (x < 2) {
            return x;
        }
        int start = 1;
        int end = x / 2;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            int sq = mid * mid;

            if (sq == x) {
                return mid;
            } else if (sq < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }
}
