package com.kovko.recursive;

import java.util.HashMap;

public class GridTraveller {

    public static void main(String[] args) {

        System.out.println(travel(1,2)); // 1
        System.out.println(travel(2,3)); // 3
        System.out.println(travel(3,2)); // 3
        System.out.println(travel(3,3)); // 6
        System.out.println(travel(18,18)); // 2333606220
    }

    private static long travel(final int n, final int m) {
        return travel(n,m, new HashMap<>());
    }
    private static long travel(final int n, final int m, HashMap<String, Long> memo) {
        String key = Math.max(m,n) + "," + Math.min(m,n);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (m == 0 || n ==0) {
            return 0;
        } else if (m == 1 && n == 1) {
            return 1;
        }
        final long l = travel(m - 1, n, memo) + travel(m, n - 1, memo);
        memo.put(key, l);
        return l;
    }

}
