package com.example;

public class Q392 {
    public static boolean isSubsequence(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        int fast = 0;
        int slow = 0;

        while (fast < arrT.length && slow < arrS.length) {
            if (arrT[fast] == arrS[slow]) {
                slow++;
            }

            fast++;
        }

        return slow == arrS.length;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "ahbgdc"));
    }
}
