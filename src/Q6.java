package com.example;

public class Q6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] array = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            array[i] = new StringBuilder();
        }

        int index = 0;
        boolean needTurn = true;

        for (char ch : s.toCharArray()) {
            array[index].append(ch);

            if (index == 0 || index == numRows - 1) {
                needTurn = !needTurn;
            }

            index += needTurn ? -1 : 1;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder sb : array) {
            result.append(sb);
        }

        return result.toString();
    }

}
