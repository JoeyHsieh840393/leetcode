package com.example;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
    }

    public static int solution(int n) {
        if (n <= 2) {
            return n;
        }

        int temp = 0;
        int n1 = 1;
        int n2 = 2;

        for (int i = 3; i <= n; i++) {
            temp = n1 + n2;

            n1 = n2;
            n2 = temp;
        }

        return temp;
    }

}
