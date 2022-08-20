package com.kovko.tabulation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllConstruct {

    public static void main(String[] args) {
        System.out.println(allConstruct("purple", List.of("purp", "p", "ur", "le", "purpl")));
        // ["purp", "le"],
        // ["p", "ur", "p", "le"]
        System.out.println(allConstruct("abcdef",List.of("ab", "abc", "cd", "def", "abcd", "ef", "c")));
        // ["ab", "cd", "ef"]
        // ["ab", "c", "def"]
        // ["abc", "def"]
        // ["abcd", "ef"]
        System.out.println(allConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "boar")));
        //[]
        System.out.println(allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaz", List.of("a", "aa", "aaa","aaaa","aaaaa" )));
        //[]
    }

    private static List<List<String>> allConstruct(final String target, final List<String> strings) {
        var table = Stream.generate(ArrayList<List<String>>::new).limit(target.length() + 1).collect(Collectors.toList());
        var ways = new ArrayList<List<String>>();
        ways.add(new ArrayList<>());
        table.set(0, ways);
        for (int i = 0; i < table.size(); i++) {
            final List<List<String>> currentWays = new ArrayList<>(table.get(i));
            if (!currentWays.isEmpty()) {
                for (final String string : strings) {
                    final var tempResult = new ArrayList<List<String>>();
                    if (target.startsWith(string, i)) {
                        for (final List<String> way : currentWays) {
                            final var newWays = new ArrayList<>(way);
                            newWays.add(string);
                            tempResult.add(newWays);
                        }
                    }
                    final int position = i + string.length();
                    if (!tempResult.isEmpty() && position < table.size()) {
                        table.get(position).addAll(tempResult);
                    }
                }
            }
        }
        return table.get(target.length());
    }
}
