package com.example;

import java.util.Arrays;

public class Q26 {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        // int[] nums = new int[] { 1,1,2};

        System.out.println(solution(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int solution(int[] nums) {
        int k = 1, size = nums.length;
        
        if (size <= 1) {
            return size;
        }

        for (int i = 1; i < size; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
