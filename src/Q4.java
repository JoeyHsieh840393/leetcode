package com.example;

import java.util.Arrays;

public class Q4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];

        int index1 = 0, index2 = 0, index3 = 0;

        while (index1 < nums1.length || index2 < nums2.length) {
            if (index1 >= nums1.length) {
                nums3[index3++] = nums2[index2++];
            } else if (index2 >= nums2.length) {
                nums3[index3++] = nums1[index1++];
            } else if (nums1[index1] < nums2[index2]) {
                nums3[index3++] = nums1[index1++];
            } else {
                nums3[index3++] = nums2[index2++];
            }
        }

        System.out.println(Arrays.toString(nums3));

        if ((nums3.length & 1) == 1) {
            int mid = (nums3.length >>> 1);
            return nums3[mid];
        } else {
            int m1 = (nums3.length >>> 1) - 1;
            int m2 = m1 + 1;

            return ((double) nums3[m1] + nums3[m2]) / 2;
        }
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int[] nums3 = new int[(total >>> 1) + 1];

        int index1 = 0, index2 = 0, index3 = 0;

        while ((index1 < nums1.length || index2 < nums2.length) && index3 < nums3.length) {
            if (index1 >= nums1.length) {
                nums3[index3++] = nums2[index2++];
            } else if (index2 >= nums2.length) {
                nums3[index3++] = nums1[index1++];
            } else if (nums1[index1] < nums2[index2]) {
                nums3[index3++] = nums1[index1++];
            } else {
                nums3[index3++] = nums2[index2++];
            }
        }

        return (total & 1) == 1 ? nums3[nums3.length - 1]
                : ((double) nums3[nums3.length - 1] + nums3[nums3.length - 2]) / 2;
    }

    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays3(nums2, nums1);
        }

        int size1 = nums1.length, size2 = nums2.length;
        int left = 0, right = size1;
        int half = (size1 + size2 + 1) / 2;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;

            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == size1) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == size2) ? Integer.MAX_VALUE : nums2[j];

            if (nums1Left > nums2Right) {
                right = i - 1;
            } else if (nums2Left > nums1Right) {
                left = i + 1;
            } else {
                int leftMax = Math.max(nums1Left, nums2Left);
                if (((size1 + size2) & 1) == 1) {
                    return leftMax;
                }
                int rightMin = Math.min(nums1Right, nums2Right);
                return (leftMax + rightMin) / 2.0;
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays3(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }));
        System.out.println(findMedianSortedArrays2(new int[] { 1, 3 }, new int[] { 2 }));
    }
}
