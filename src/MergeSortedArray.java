package com.example;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = new int[] { 2, 5, 6 };

        soluation(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[] { 1, 2, 3, 4, 0, 0, 0 };
        nums2 = new int[] { 2, 5, 6 };

        soluation(nums1, 4, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[] { 1 };
        nums2 = new int[] {};
        soluation(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[] { 0 };
        nums2 = new int[] { 1 };
        soluation(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[] { 0, 0, 0 };
        nums2 = new int[] { 1, 2, 3 };
        soluation(nums1, 0, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[] { -1, 3, 0, 0, 0, 0, 0 };
        nums2 = new int[] { 0, 0, 1, 2, 3 };
        soluation(nums1, 2, nums2, 5);
        System.out.println(Arrays.toString(nums1));
    }

    public static void soluation(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums2[j] < nums1[i]) {
                for (int k = nums1.length - 2; k >= i; k--) {
                    nums1[k + 1] = nums1[k];
                }
                nums1[i] = nums2[j];
                j++;
            } else if (i > m - 1 && nums1[i] == 0) {
                nums1[i] = nums2[j];
                j++;
                // i++;
            }
            i++;
        }
    }

}
