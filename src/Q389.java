package com.example;

import java.util.Random;

public class Q389 {
    public static char findTheDifference(String s, String t) {
        System.out.println(s);
        System.out.println(t);

        int[] freq = new int[26];

        for (char chS : s.toCharArray()) {
            freq[chS - 'a']++;
        }

        for (char chT : t.toCharArray()) {
            freq[chT - 'a']--;

            if (freq[chT - 'a'] == -1) {
                return chT;
            }
        }

        return 'a';
    }

    public static void main(String[] args) {
        Random random = new Random();

        String s = "abcdefg";
        String t = s + (char) random.nextInt(97, 123);

        char[] chars = t.toCharArray();

        for (int i = t.length() - 1; i >= 0; i--) {
            int index = random.nextInt(i + 1);

            char backup = chars[index];
            chars[index] = chars[i];
            chars[i] = backup;
        }

        t = new String(chars);
        System.out.println(findTheDifference(s, t));
    }
}
