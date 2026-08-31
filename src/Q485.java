package com.example;

public class Q485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int consecut = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                consecut++;
                if (consecut > max) {
                    max = consecut;
                }
            } else {
                consecut = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
    }
}
