package com.example;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow2(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        long prev = 1L;

        for (int i = 1; i < rowIndex + 1; i++) {
            prev = prev * (rowIndex - i + 1) / i;
            result.add((int) prev);
        }

        return result;
    }

    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = result.size() - 1; j >= 1; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
            result.add(1);
        }

        return result;
    }
}
