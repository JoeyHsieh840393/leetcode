package com.example;

import java.util.Arrays;

public class Q345 {

    public static String reverseVowels(String s) {
        boolean[] vowels = new boolean[128];
        char[] chars = s.toCharArray();

        vowels['a'] = vowels['A'] = true;
        vowels['e'] = vowels['E'] = true;
        vowels['i'] = vowels['I'] = true;
        vowels['o'] = vowels['O'] = true;
        vowels['u'] = vowels['U'] = true;

        int left = 0;
        int right = chars.length - 1;
        char temp = ' ';

        while (left < right) {

            if (vowels[chars[left]] && vowels[chars[right]]) {
                temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            } else if (!vowels[chars[left]]) {
                left++;
            } else if (!vowels[chars[right]]) {
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        // System.out.println(reverseVowels("abcde"));
        System.out.println(reverseVowels("IceCreAm"));
    }
}
