package com.example;

import java.util.Arrays;

public class Q414 {
    public static int thirdMax(int[] nums) {
        int[] nums2 = Arrays.stream(nums).distinct().sorted().toArray();

        if (nums2.length >= 3) {
            return nums2[nums2.length - 3];
        } else {
            return nums2[nums2.length - 1];
        }
    }

    public static int thirdMax2(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int num : nums) {
            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num < firstMax && num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num < firstMax && num < secondMax && num > thirdMax) {
                thirdMax = num;
            }
        }
        return thirdMax == Long.MIN_VALUE ? (int) firstMax : (int) thirdMax;
    }

    public static void main(String[] args) {
        System.out.println(thirdMax2(new int[] { 1, 2 }));
    }
}
