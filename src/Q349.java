package com.example;

import java.util.HashSet;
import java.util.Set;

public class Q349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        boolean[] map = new boolean[1001];
        int[] temp = new int[Math.min(nums1.length, nums2.length)];

        for (int num1 : nums1) {
            map[num1] = true;
        }

        int count = 0;

        for (int num2 : nums2) {
            if (map[num2]) {
                temp[count] = num2;
                count++;
                map[num2] = false;
            }
        }

        int[] result = new int[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }
}
