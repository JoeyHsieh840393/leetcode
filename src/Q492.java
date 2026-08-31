package com.example;

public class Q492 {
    public int[] constructRectangle(int area) {
        int start = 1, end = area;

        int[] result = new int[] { area, 1 };

        while (start < end) {
            if (area % start == 0) {
                end = area / start;
                if (end - start < result[0] - result[1]) {
                    result[1] = start;
                    result[0] = end;
                }
            } else if (area % end == 0) {
                start = area / end;
                if (end - start < result[0] - result[1]) {
                    result[1] = start;
                    result[0] = end;
                }
            }

            start++;
            end--;
        }

        return result;
    }
}
