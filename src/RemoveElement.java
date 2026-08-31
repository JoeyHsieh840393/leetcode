package com.example;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 2, 3 };
        System.out.println(solution(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

    public static int solution(int[] nums, int val) {
        int a = 0, size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] != val) {
                nums[a] = nums[i];
                a++;
            }
        }
        return a;
    }
}
