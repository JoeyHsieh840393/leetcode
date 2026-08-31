package com.example;

public class Q202 {

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        if (n < 10) {
            return false;
        }

        int nCopy = n;
        do {
            int num = 0;

            while (nCopy > 0) {
                int r = nCopy % 10;
                num += r * r;

                nCopy /= 10;
            }

            nCopy = num;
        } while (nCopy != 1 && nCopy != 4);

        return nCopy == 1;
    }

    public static boolean isHappy2(int n) {
        int fast = n;
        int slow = n;

        do {
            slow = next(slow);
            fast = next(next(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int next(int n) {
        int num = 0;

        while (n > 0) {
            int r = n % 10;
            num += r * r;

            n /= 10;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(Integer.MAX_VALUE));
        System.out.println(isHappy2(28));

    }
}
