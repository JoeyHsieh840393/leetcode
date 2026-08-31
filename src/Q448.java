package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        int index = 0;

        while (index < n) {
            int num = nums[index];
            if (num != nums[num - 1]) {
                int temp = nums[index];
                nums[index] = nums[num - 1];
                nums[num - 1] = temp;
            } else {
                index++;
            }
        }

        System.out.println(Arrays.toString(nums));

        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                result.add(j + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
    }
}
