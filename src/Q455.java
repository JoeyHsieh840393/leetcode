package com.example;

import java.util.Arrays;

public class Q455 {
    public static int findContentChildren(int[] g, int[] s) {
        int i = 0, j = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while (j < s.length && i < g.length) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }

        return i;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[] { 1, 2, 3 }, new int[] { 1, 1 }));
        System.out.println(findContentChildren(new int[] { 1, 2 }, new int[] { 1, 2, 3 }));
        System.out.println(findContentChildren(new int[] { 10, 9, 8, 7 }, new int[] { 5, 6, 7, 8 }));
    }
}
