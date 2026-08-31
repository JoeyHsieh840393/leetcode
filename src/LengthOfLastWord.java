package com.example;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.err.println(solution("   fly me   to   the moon  "));
    }

    public static int solution(String s) {
        int start = s.length() - 1;
        int length = 0;

        while (start >= 0 && s.charAt(start) == ' ') {
            start--;
        }

        while (start >= 0 && s.charAt(start) != ' ') {
            length++;
            start--;
        }
        return length;
    }
}
