package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q205 {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1)) {
                if (!map1.get(c1).equals(c2)) {
                    return false;
                }
            } else {
                map1.put(c1, c2);
            }

            if (map2.containsKey(c2)) {
                if (!map2.get(c2).equals(c1)) {
                    return false;
                }
            } else {
                map2.put(c2, c1);
            }
        }
        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        int[] num1 = new int[256];
        int[] num2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (num1[c1] != num2[c2]) {
                return false;
            }

            num1[c1] = i + 1;
            num2[c2] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        // System.out.println(isIsomorphic("egg", "add"));
        // System.out.println(isIsomorphic("f11", "b23"));
        // System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("abc", "aab"));
        System.out.println(isIsomorphic2("abc", "aab"));
        System.out.println(isIsomorphic2("aaa", "bbb"));
    }
}
