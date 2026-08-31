package com.example;

public class Q12 {
    public static String intToRoman(int num) {
        int[] val = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] sym = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder answer = new StringBuilder(8);

        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                answer.append(sym[i]);
                num -= val[i];
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3999));

        // for (int i = 40; i <= 49; i++) {
        //     System.out.println(intToRoman(i));
        // }
    }
}
