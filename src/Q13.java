package com.example;

public class Q13 {
    public static int romanToInt(String s) {
        int[] input = new int[s.length()];
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 'I':
                    input[i] = 1;
                    break;
                case 'V':
                    input[i] = 5;
                    break;
                case 'X':
                    input[i] = 10;
                    break;
                case 'L':
                    input[i] = 50;
                    break;
                case 'C':
                    input[i] = 100;
                    break;
                case 'D':
                    input[i] = 500;
                    break;
                case 'M':
                    input[i] = 1000;
                    break;
                default:
                    break;
            }
        }

        int result = 0;

        for (int j = 0, size = input.length; j < size; j++) {

            if (j < size - 1 && input[j] < input[j + 1]) {
                result -= input[j];
            } else {
                result += input[j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
