package com.example;

public class Q121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(maxProfit(new int[] { 7, 6, 5, 4, 3, 2, 1 }));
        System.out.println(maxProfit(new int[] { 2, 4, 1 }));
        System.out.println(maxProfit(new int[] { 2, 3, 4, 0, 1 }));
        System.out.println(maxProfit(new int[] { 1, 2 }));
    }

    public static int maxProfit(int[] prices) {
        int maxProfitValue = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else {
                maxProfitValue = Math.max(maxProfitValue, prices[i] - min);
            }
        }

        return maxProfitValue;
    }

}
