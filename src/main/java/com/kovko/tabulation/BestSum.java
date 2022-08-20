package com.kovko.tabulation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BestSum {

    public static void main(String[] args) {
        System.out.println(bestSum(7, List.of(5, 3, 4, 7))); //[7]
        System.out.println(bestSum(8, List.of(2, 3, 5))); // [3, 5]
        System.out.println(bestSum(8, List.of(1, 4, 5))); // [4, 4]
        System.out.println(bestSum(100, List.of(1, 2, 5, 25))); //[25, 25, 25, 25]
    }

    private static List<Integer> bestSum(final int targetSum, final List<Integer> integers) {
        final long size = targetSum + 1;
        var table = Stream.generate(() -> (List<Integer>) null).limit(size).collect(Collectors.toList());
        table.set(0, new ArrayList<>());
        for (int i = 0; i < table.size(); i++) {
            final List<Integer> currentList = table.get(i);
            if (currentList != null) {
                for (final Integer integer : integers) {
                    final int position = integer + i;
                    final boolean indexIsInBounds = position <= targetSum;
                    final List<Integer> targetList = table.get(position);
                    if (indexIsInBounds &&
                        (targetList == null ||
                         targetList.size() > currentList.size() + 1)) {
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
