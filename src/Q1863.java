package com.example;

public class Q1863 {
    public static int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    private static int helper(int[] nums, int index, int collect) {
        if (index >= nums.length) {
            return collect;
        }

        return helper(nums, index + 1, collect ^ nums[index]) + helper(nums, index + 1, collect);
    }

    public static int subsetXORSum2(int[] nums) {
        int[] result = { 0 };
        helper2(nums, 0, 0, result);
        return result[0];
    }

    private static void helper2(int[] nums, int index, int collect, int[] result) {
        if (index >= nums.length) {
            result[0] += collect;
            return;
        }

        helper2(nums, index + 1, collect ^ nums[index], result);
        helper2(nums, index + 1, collect, result);
    }

    public static void main(String[] args) {
        System.out.println(subsetXORSum2(new int[] { 1, 3 }));
    }
}
