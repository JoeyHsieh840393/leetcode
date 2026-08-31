package com.example;

import java.util.Arrays;

public class Q242 {
    public static boolean isAnagram(String s, String t) {
        int[] nums = new int[26];

        for (int j = 0; j < s.length(); j++) {
            nums[s.charAt(j) - 'a']++;
        }

        System.out.println(Arrays.toString(nums));

        for (int k = 0; k < t.length(); k++) {
            nums[t.charAt(k) - 'a']--;
        }

        System.out.println(Arrays.toString(nums));

        int sum = 0;

        for (int num : nums) {
            if (num < 0) {
                return false;
            }
            sum += num;
        }

        return sum == 0;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("aa", "bb"));
    }
}
