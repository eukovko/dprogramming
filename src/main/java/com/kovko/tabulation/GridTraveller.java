package com.kovko.tabulation;

import java.util.Arrays;

public class GridTraveller {

    public static void main(String[] args) {

        System.out.println(travel(1,2)); // 1
        System.out.println(travel(2,3)); // 3
        System.out.println(travel(3,2)); // 3
        System.out.println(travel(3,3)); // 6
        System.out.println(travel(18,18)); // 2333606220
    }

    private static long travel(final int rows, final int cols) {

        final long[][] grid = new long[rows + 1][cols + 1];
        grid[1][1] = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                grid[i][j] += grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[rows][cols];
    }

}
