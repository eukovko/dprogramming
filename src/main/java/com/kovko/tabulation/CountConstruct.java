package com.kovko.tabulation;

import java.util.List;

public class CountConstruct {

    public static void main(String[] args) {
        System.out.println(countConstruct("purple", List.of("purp", "p", "ur", "le", "purpl"))); // 2
        System.out.println(countConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd"))); // 1
        System.out.println(countConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar"))); // 0
        System.out.println(countConstruct("enterapotentpot", List.of( "a", "p", "ent", "enter", "ot", "o", "t"))); // 4
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee"))); // 0
    }

    private static int countConstruct(final String target, final List<String> strings) {
        final int size = target.length() + 1;
        final int[] table = new int[size];
        table[0] = 1;
        for (int i = 0; i < table.length; i++) {
            for (final String string : strings) {
                final int position = i + string.length();
                if (position < size && target.startsWith(string, i)) {
                    table[position] += table[i];
                }
            }
        }
        return table[size - 1];
    }

}
