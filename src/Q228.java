package com.example;

import java.util.ArrayList;
import java.util.List;

public class Q228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        int slow = 0;
        for (int i = 1; i <= nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            if (i == nums.length || nums[i] - nums[i - 1] != 1) {
                if (slow == i - 1) {
                    // list.add(String.valueOf(nums[slow]));
                    list.add(sb.append(nums[slow]).toString());
                } else {
                    // list.add(String.format("%d->%d", nums[slow], nums[i - 1]));
                    list.add(sb.append(nums[slow]).append("->").append(nums[i - 1]).toString());
                }
                slow = i;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }));
        // System.out.println(summaryRanges(new int[] { 0, 1, 2, 5, 7, 8 }));
        // System.out.println(summaryRanges(new int[] { 0, 2, 3, 6, 7, 8 }));
        // System.out.println(summaryRanges(new int[] { -1 }));
    }
}
