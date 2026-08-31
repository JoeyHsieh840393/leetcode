package com.example;

public class Q367 {
    public static boolean isPerfectSquare(int num) {
        float squareRoot = num;
        float squareRootPrev = num;
        float accurate = 0.001f;

        int count = 0;

        do {
            count++;
            squareRootPrev = squareRoot;
            squareRoot = (squareRoot + ((float) num / squareRoot)) / 2;
        } while (Math.abs(squareRoot - squareRootPrev) > accurate);
        System.out.println(count);
        int n = (int) (squareRoot);
        return n * n == num;
    }

    public static boolean isPerfectSquare2(int num) {
        int start = 1;
        int end = num;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long squareMid = (long) mid * mid;
            if (squareMid > num) {
                end = mid - 1;
            } else if (squareMid < num) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(Integer.MAX_VALUE));
        // System.out.println(isPerfectSquare2(Integer.MAX_VALUE));

    }
}
