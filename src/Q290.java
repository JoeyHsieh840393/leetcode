package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q290 {
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        char[] chars = pattern.toCharArray();
        String[] strs = s.split(" ");

        if (chars.length != strs.length) {
            return false;
        }

        for (int i = 0; i < chars.length; i++) {
            String value1 = map1.get(chars[i]);
            Character value2 = map2.get(strs[i]);

            if (value1 != null) {
                if (!value1.equals(strs[i])) {
                    return false;
                }
            } else if (value2 != null) {
                if (!value2.equals(chars[i])) {
                    return false;
                }
            } else {
                map1.put(chars[i], strs[i]);
                map2.put(strs[i], chars[i]);
            }

        }
        return true;
    }

    public static boolean wordPattern2(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        char[] chars = pattern.toCharArray();
        String[] strs = s.split(" ");

        for (int i = 0; i < chars.length; i++) {
            String prev = map.putIfAbsent(chars[i], strs[i]);

            if (prev != null) {
                if (!prev.equals(strs[i])) {
                    return false;
                }
            } else {
                if (!set.add(chars[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "aa bb bb aa"));
    }
}
