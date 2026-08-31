package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        int[] array = new int[1001];

        int[] repeat = new int[Math.min(nums1.length, nums2.length)];
        
        int k = 0;

        for (int num1 : nums1) {
            array[num1]++;
        }

        for (int num2 : nums2) {
            if (array[num2] > 0) {
                repeat[k++] = num2;
                array[num2]--;
            }
        }

        return Arrays.copyOf(repeat, k);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[] { 1, 2, 2, 2 }, new int[] { 2, 2, 4, 5 })));
    }
}
