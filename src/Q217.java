package com.example;

import java.util.Arrays;

public class Q217 {
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int value = nums[i];

            while (j >= 0 && nums[j] > value) {
                nums[j + 1] = nums[j];
                j--;
            }

            if (j >= 0 && value == nums[j]) {
                return true;
            }
            nums[j + 1] = value;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 1 }));
    }
}
