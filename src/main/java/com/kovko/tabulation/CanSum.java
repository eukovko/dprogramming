package com.kovko.tabulation;

import java.util.List;

public class CanSum {

    public static void main(String[] args) {
        System.out.println(canSum(7, List.of(2, 3))); // true
        System.out.println(canSum(7, List.of(5, 3, 4, 7))); // true
        System.out.println(canSum(7, List.of(2, 4))); // false
        System.out.println(canSum(8, List.of(2, 3, 5))); // true
        System.out.println(canSum(300, List.of(7, 14))); // false
    }

    private static boolean canSum(final int target, final List<Integer> integers) {
        final boolean[] table = new boolean[target + 1];
        table[0] = true;

        for (int i = 0; i <= target; i++) {
            if (table[i]) {
                for (final Integer integer : integers) {
                    final int position = i + integer;
                    if (position <= target) {
                        table[position] = true;
                    }
                }
            }
        }

        return table[target];
    }
}
