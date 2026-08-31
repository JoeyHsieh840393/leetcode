package com.example;

public class Q3304 {
    public static char kthCharacter(int k) {
        String word = "a";

        return helper(k, word);
    }

    private static char helper(int k, String word) {
        if (word.length() >= k) {
            return word.charAt(k - 1);
        }

        StringBuilder sb = new StringBuilder(word);

        for (char ch : word.toCharArray()) {
            char nextChar = ch == 'z' ? 'a' : (char) (ch + 1);
            sb.append(nextChar);
        }

        return helper(k, sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(kthCharacter(5));
    }
}
