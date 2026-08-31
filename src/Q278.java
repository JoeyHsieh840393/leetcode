package com.example;

public class Q278 {
    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (isBadVersion(mid)) {
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }

    private static boolean isBadVersion(int n) {
        return n == 1702766719;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(Integer.MAX_VALUE));
    }
}
