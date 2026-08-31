package com.example;

import java.util.Arrays;

public class Q283 {
    public static void moveZeroes(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;

                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 7, 0, 5, 1, 2, 3, 4 };
        // int[] nums = new int[] { 0 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
