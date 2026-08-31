package com.example;

public class Q7 {
    public static int reverse(int x) {
        int reverseNum = 0;
        while (x != 0) {
            int r = x % 10;
            x /= 10;

            if (reverseNum > Integer.MAX_VALUE / 10 || (reverseNum == Integer.MAX_VALUE && r >7)) {
                return 0;
            }
            if (reverseNum < Integer.MIN_VALUE / 10 || (reverseNum == Integer.MIN_VALUE && r < -8)) {
                return 0;
            }

            reverseNum = 10 * reverseNum + r;

        }
        return reverseNum;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
        System.out.println(Integer.MIN_VALUE);
    }
}
