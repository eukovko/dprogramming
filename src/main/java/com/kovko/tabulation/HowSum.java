package com.kovko.tabulation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HowSum {

    public static void main(String[] args) {
        System.out.println(howSum(7, List.of(2, 3))); // [3, 2, 2]
        System.out.println(howSum(7,List.of(5, 3, 4, 7))); // [4,3]
        System.out.println(howSum(7,List.of(2, 4))); // null
        System.out.println(howSum(8,List.of(2, 3, 5))); // [2, 2, 2, 2]
        System.out.println(howSum(300,List.of(7, 14))); // null
    }

    private static List<Integer> howSum(final int targetSum, final List<Integer> integers) {
        final long size = targetSum + 1;
        var table = Stream.generate(() -> (List<Integer>) null).limit(size).collect(Collectors.toList());
        table.add(0, new ArrayList<>());
        for (int i = 0; i < table.size(); i++) {
            final List<Integer> currentList = table.get(i);
            if (currentList != null) {
                for (final Integer integer : integers) {
                    final int position = integer + i;
                    if (position <= targetSum) {
                        final ArrayList<Integer> newList = new ArrayList<>(currentList);
                        newList.add(integer);
                        table.set(position, newList);
                    }
                }
            }
        }
        return table.get(targetSum);
    }
}
