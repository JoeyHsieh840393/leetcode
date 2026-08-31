package com.example;

import java.util.Arrays;

public class Q169 {
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxCount = nums.length / 2;
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);

        int count = 1;
        for (int i = 1, size = numsCopy.length; i < size; i++) {
            if (numsCopy[i - 1] == numsCopy[i]) {
                count++;
            } else {
                count = 1;
            }

            if (count > maxCount) {
                return numsCopy[i];
            }
        }
        return -1;
    }

    public static int majorityElement2(int[] nums) {
        int count = 1;
        int ref = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                ref = nums[i];
                count = 1;
            } else if (nums[i] == ref) {
                count++;
            } else {
                count--;
            }
        }

        return ref;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement2(new int[] { 2, 2, 1, 1, 1, 1, 1, 3, 3, 3 }));
        // System.out.println(majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
        // System.out.println(majorityElement(new int[] { 6 }));
    }
}
