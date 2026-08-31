package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int[][] array = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            array[i][0] = nums[i];
            array[i][1] = i;
        }

        Arrays.sort(array, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = 0; i < nums.length - 1; i++) {
            if (array[i][0] == array[i + 1][0] && Math.abs(array[i][1] - array[i + 1][1]) <= k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 99, 99 };
        // int[] nums = new int[] { 1, 2, 3, 1, 2, 3 };
        System.out.println(containsNearbyDuplicate(nums, 2));
    }
}
