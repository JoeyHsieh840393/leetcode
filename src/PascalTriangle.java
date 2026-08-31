package com.example;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);

        for (int i = 0; i < result.size(); i++) {
            System.out.printf("Row %d => ", i + 1);
            System.out.println(result.get(i));
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            
            for (int j = 1; j < i; j++) {
                List<Integer> prevRow = result.get(i - 1);
                int num = prevRow.get(j) + prevRow.get(j - 1);
                newRow.add(num);
            }
            newRow.add(1);
            result.add(newRow);
        }
        return result;
    }
}
