package com.kovko.recursive;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(6)); // 8
        System.out.println(fib(7)); // 13
        System.out.println(fib(8)); // 21
        System.out.println(fib(50)); // 12586269025
    }

    private static long fib(final int n) {
        return fib(n, new HashMap<>());
    }
    private static long fib(final int n, Map<Integer, Long> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        final long f = fib(n - 1, memo) + fib(n - 2, memo);
        memo.put(n, f);
        return f;
    }
}
