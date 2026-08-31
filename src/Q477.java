package com.example;

public class Q477 {
    public static int totalHammingDistance(int[] nums) {
        int point = 1;
        int distance = 0;
        for (int i = 0; i < 32; i++, point <<= 1) {
            int zeroCount = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & point) == 0) {
                    zeroCount++;
                }
            }
            distance += (zeroCount * (nums.length - zeroCount));
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(totalHammingDistance(new int[] { 4, 14, 2 }));
        System.out.println(totalHammingDistance(new int[] { 4, 14, 4 }));
    }
}
