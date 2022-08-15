package com.kovko;

import java.util.HashMap;
import java.util.List;

public class CanSum {

    public static void main(String[] args) {
        System.out.println(canSum(7, List.of(2, 3))); // true
        System.out.println(canSum(7, List.of(5, 3, 4, 7))); // true
        System.out.println(canSum(7, List.of(2, 4))); // false
        System.out.println(canSum(8, List.of(2, 3, 5))); // true
        System.out.println(canSum(300, List.of(7, 14))); // false
    }

    private static boolean canSum(final int n, final List<Integer> integers) {
        return canSum(n, integers, new HashMap<>());
    }
    private static boolean canSum(final int n, final List<Integer> integers, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 0) {
            return true;
        } else if (n < 0) {
            return false;
        }
        for (final Integer integer : integers) {
            if (canSum(n - integer, integers, memo)) {
                memo.put(n, true);
                return true;
            }
        }
        memo.put(n, false);
        return false;
    }


}
