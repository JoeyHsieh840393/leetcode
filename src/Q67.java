package com.example;

public class Q67 {
    public static void main(String[] args) {
        System.out.println(addBinary("0", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        char[] result = new char[Math.max(arrA.length, arrB.length)];

        StringBuilder sb = new StringBuilder(result.length);

        int indexA = arrA.length - 1, indexB = arrB.length - 1, indexResult = result.length - 1;
        int carry = 0;

        while (indexA >= 0 || indexB >= 0) {
            int x = 0, y = 0;

            if (indexA >= 0) {
                x = arrA[indexA] - '0';
                indexA--;
            }

            if (indexB >= 0) {
                y = arrB[indexB] - '0';
                indexB--;
            }

            int sum = x + y + carry;
            result[indexResult--] = (char) ((sum & 1) + '0');
            carry = sum >> 1;
        }

        if(carry > 0){
            sb.append(carry);
        }

        return sb.append(result).toString();

    }
}
