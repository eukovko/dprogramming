package com.kovko;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HowSum {

    public static void main(String[] args) {
        System.out.println(howSum(7, List.of(2, 3))); // [3, 2, 2]
        System.out.println(howSum(7,List.of(5, 3, 4, 7))); // [4,3]
        System.out.println(howSum(7,List.of(2, 4))); // null
        System.out.println(howSum(8,List.of(2, 3, 5))); // [2, 2, 2, 2]
        System.out.println(howSum(300,List.of(7, 14))); // null
    }

    private static List<Integer> howSum(final int n, final List<Integer> integers) {
        return howSum(n, integers, new HashMap<>());
    }
    private static List<Integer> howSum(final int n, final List<Integer> integers, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n < 0) {
            return null;
        } else if (n == 0) {
            return new LinkedList<>();
        }
        for (final Integer integer : integers) {
            final List<Integer> result = howSum(n - integer, integers, memo);
            if (result != null) {
                result.add(0, integer);
                memo.put(n, new LinkedList<>(result));
                return result;
            }
        }
        memo.put(n, null);
        return null;
    }

}
