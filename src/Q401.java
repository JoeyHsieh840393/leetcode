package com.example;

import java.util.ArrayList;
import java.util.List;

public class Q401 {
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    result.add(String.format("%d:%02d", i, j));
                }
            }
        }

        return result;
    }

    public static List<String> readBinaryWatch2(int turnedOn) {
        int[] led = new int[] { 8, 4, 2, 1, 32, 16, 8, 4, 2, 1 };
        List<String> result = new ArrayList<>();

        help(result, led, turnedOn, 0, 0, 0);

        return result;

    }

    private static void help(List<String> result, int[] led, int remain, int index, int hour, int minute) {
        if (remain == 0) {
            if (hour < 12 && minute < 60) {
                result.add(String.format("%d:%02d", hour, minute));
            }
            return;
        }

        if (index >= led.length) {
            return;
        }

        help(result, led, remain, index + 1, hour, minute);
        
        if (index < 4) {
            help(result, led, remain - 1, index + 1, hour + led[index], minute);
        } else {
            help(result, led, remain - 1, index + 1, hour, minute + led[index]);
        }
    }

    public static void main(String[] args) {

        System.out.println(readBinaryWatch2(2));

    }
}
