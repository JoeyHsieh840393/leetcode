package com.example;

public class Q409 {
    public static int longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int[] freq = new int[52];

        for (char ch : arr) {
            if ('A' >= ch && 'Z' <= ch) {
                freq[ch - 'A']++;
            } else {
                freq[26 + (ch - 'a')]++;
            }
        }

        int count = 0;
        boolean hasOdd = false;

        for (int f : freq) {
            if ((f & 1) == 0) {
                count += f;
            } else {
                count += (f - 1);
                hasOdd = true;
            }
        }

        return hasOdd ? count + 1 : count;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcccdd"));
        System.out.println(longestPalindrome("ccc"));
    }
}
