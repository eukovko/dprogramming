package com.kovko.tabulation;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(6)); // 8
        System.out.println(fib(7)); // 13
        System.out.println(fib(8)); // 21
        System.out.println(fib(50)); // 12586269025
    }

    public static long fib(int n) {

        final long[] sequence = new long[n + 1];
        sequence[0] = 0;
        sequence[1] = 1;
        for (int i = 2; i <= n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence[n];
    }
}
