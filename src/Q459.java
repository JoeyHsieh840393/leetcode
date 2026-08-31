package com.example;

public class Q459 {
    public static boolean repeatedSubstringPattern(String s) {
        char[] arr = s.toCharArray();
        int length = arr.length;

        a: for (int repeatCount = 2; repeatCount <= length; repeatCount++) {
            if (length % repeatCount == 0) {
                int patternLength = length / repeatCount;

                char[] pattern = s.substring(0, patternLength).toCharArray();

                for (int k = 0; k < length; k++) {
                    if (pattern[k % patternLength] != arr[k]) {
                        continue a;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean repeatedSubstringPattern2(String s) {
    int n = s.length();
    int[] next = new int[n];
    int len = 0;
    for (int i = 1; i < n; i++) {
        while (len > 0 && s.charAt(i) != s.charAt(len)) {
            len = next[len - 1];
        }
        if (s.charAt(i) == s.charAt(len)) {
            len++;
        }
        next[i] = len;
    }
    
    int longestBorder = next[n - 1];
    return longestBorder > 0 && n % (n - longestBorder) == 0;
}

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern2("ababab"));
        // System.out.println(repeatedSubstringPattern("aba"));
        
    }
}
