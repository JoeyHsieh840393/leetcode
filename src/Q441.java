package com.example;

public class Q441 {
    public static int arrangeCoins(int n) {
        int i = 0;

        do {
            i++;
            n -= i;
        } while (n > 0);

        return n < 0 ? i - 1 : i;
    }

    public static int arrangeCoins2(int n) {
        long start = 1;
        long end = n;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long a = mid * (mid + 1) / 2;

            if (a < n) {
                start = mid + 1;
            } else if (a > n) {
                end = mid - 1;
            } else {
                return (int) mid;
            }
        }
        return (int) end;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins2(Integer.MAX_VALUE));
        System.out.println(arrangeCoins2(8));
    }
}
