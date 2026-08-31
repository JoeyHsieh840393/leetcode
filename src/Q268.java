package com.example;

public class Q268 {
    public static int missingNumber(int[] nums) {
        int xor = 0;

        for (int n : nums) {
            System.out.printf("%d ^ %d = ", xor, n);
            xor ^= n;
            System.out.printf("%d%n", xor);
        }

        for (int i = 0; i <= nums.length; i++) {
            System.out.printf("%d ^ %d = ", xor, i);
            xor ^= i;
            System.out.printf("%d%n", xor);
        }

        return xor;
    }

    public static void main(String[] args) {
        missingNumber(new int[] { 0, 1, 3 });
    }
}
