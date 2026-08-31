package com.example;

public class Q463 {
    public static int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        // int island = 0, neighbour = 0;
        int perimeter = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    if (i > 0) {
                        perimeter -= 2 * grid[i - 1][j] * grid[i][j];
                    }

                    if (j > 0) {
                        perimeter -= 2 * grid[i][j - 1] * grid[i][j];
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } }));
    }
}
