package com.example;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        // System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("abcleetcode", "leet"));
        // System.out.println(strStr("abc", "c"));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }

        int haystackSize = haystack.length(), needleSize = needle.length();

        for (int i = 0; i <= haystackSize - needleSize; i++) {
            String str = haystack.substring(i, i + needle.length());
            if (str.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
