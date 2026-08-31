package com.example;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5));
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 2));
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7));
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 0));

    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (end + start) / 2;
            
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            }else{
                return mid;
            }
        }

        return start;
    }
}
