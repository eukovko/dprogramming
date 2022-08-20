package com.kovko.recursive;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BestSum {

    public static void main(String[] args) {
        System.out.println(bestSum(7, List.of(5, 3, 4, 7))); //[7]
        System.out.println(bestSum(8, List.of(2, 3, 5))); // [3, 5]
        System.out.println(bestSum(8, List.of(1, 4, 5))); // [4, 4]
        System.out.println(bestSum(100, List.of(1, 2, 5, 25))); //[25, 25, 25, 25]
    }

    private static List<Integer> bestSum(final int n, final List<Integer> integers) {
        return bestSum(n, integers, new HashMap<>());
    }
    private static List<Integer> bestSum(final int n, final List<Integer> integers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 0) {
            return new LinkedList<>();
        } else if (n < 0) {
            return null;
        }

        List<Integer> bestResult = null;
        for (final Integer integer : integers) {
            List<Integer> result = bestSum(n - integer, integers, memo);
            if (result != null) {
                result = new LinkedList<>(result);
                result.add(integer);
                if (bestResult == null || bestResult.size() > result.size()) {
                    bestResult = result;
                }
            }
        }
        if (bestResult == null) {
            memo.put(n, null);
            return null;
        } else {
            memo.put(n, new LinkedList<>(bestResult));
            return memo.get(n);
        }
    }
}
