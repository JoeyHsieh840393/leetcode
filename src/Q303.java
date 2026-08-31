package com.example;

public class Q303 {
    private int[] nums;

    public Q303(int[] nums) {
        int length = nums.length;
        this.nums = new int[length + 1];
        this.nums[0] = nums[0];
        
        for (int i = 0; i < length; i++) {
            this.nums[i + 1] = this.nums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {

        return this.nums[right + 1] - this.nums[left];
    }
}
