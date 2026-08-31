package com.example;

public class Q11 {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int mostWater = 0;

        while (left < right) {
            int water = 0;
            if (height[left] >= height[right]) {
                water = height[right] * (right - left);
                right--;
            } else {
                water = height[left] * (right - left);
                left++;
            }

            mostWater = Math.max(mostWater, water);
        }

        return mostWater;
    }

    public static int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int mostWater = 0;

        while (left < right) {
            int currentheight = Math.min(height[left], height[right]);
            int currentWeight = right - left;
            int currentWater = currentWeight * currentheight;
            mostWater = Math.max(mostWater, currentWater);

            while (left < right && height[left] <= currentheight) {
                left++;
            }

            while (left < right && height[right] <= currentheight) {
                right--;
            }

        }
        return mostWater;
    }

    public static void main(String[] args) {
        System.out.println(maxArea2(new int[] { 1, 8, 6, 2, 5, 100, 100,58, 3, 7,8 }));
        System.out.println(maxArea2(new int[] { 1, 1 }));
    }
}