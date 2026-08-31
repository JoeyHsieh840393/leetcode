package com.example;

public class Q8 {
    public static int myAtoi(String s) {
        int result = 0;
        int start = 0;
        int factor = 1;
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if ((array[i] < '0' || array[i] > '9')) {
                if (array[i] == '-' || array[i] == '+' || array[i]==' ') {
                    continue;
                }
                return 0;
            }

            if (array[i] >= '0' && array[i] <= '9') {
                start = i;
                if (i > 0 && array[i - 1] == '-') {
                    factor *= -1;
                }
                break;
            }
        }

        for (int j = start; j < array.length; j++) {
            if (array[j] < '0' || array[j] > '9') {
                break;
            }

            if (array[j] >= '0' && array[j] <= '9') {
                result = result * 10 + (array[j] - '0');
            }
        }
        return result * factor;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-987"));
    }
}
