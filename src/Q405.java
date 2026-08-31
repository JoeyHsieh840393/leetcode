package com.example;

public class Q405 {
    public static String toHex(int num) {

        if (num == 0) {
            return "0";
        }

        boolean isNegative = false;

        if (num < 0) {
            isNegative = true;
            num = (num + 1) * -1;
        }

        // int[] arr = new int[32];
        char[] arr = new char[8];
        int index = arr.length - 1;

        while (num > 0 && index >= 0) {
            int remain = num % 16;

            if (remain > 9) {
                arr[index--] = (char) ('a' + (remain - 10));
            } else {
                arr[index--] = (char) ('0' + remain);
            }

            // arr[index--] = remain;
            num /= 16;
        }

        if (isNegative) {
            for (int j = 7; j >= 0; j--) {
                if (arr[j] == 'f') {
                    arr[j] = '0';
                } else {
                    arr[j] = (char) (arr[j] + 1);
                }
            }

        }

        return new String(arr);

    }

    public static String toHex2(int num) {
        if (num == 0) {
            return "0";
        }

        char[] hex = "0123456789abcdef".toCharArray();

        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            sb.append(hex[num & 15]);
            num >>>= 4;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(-1));
        // System.out.println(toHex(Integer.MAX_VALUE));
        // System.out.println(toHex(Integer.MIN_VALUE));
    }
}
