package com.kovko.tabulation;

import java.util.List;

public class CanConstruct {

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", List.of("ab" , "abc" , "cd", "def" , "abcd"))); // true
        System.out.println(canConstruct("skateboard", List.of("bo" , "rd" , "ate" , "t" , "ska" , "sk" , "boar"))); // false
        System.out.println(canConstruct("enterapotentpot" , List.of("a", "p", "ent", "enter", "ot", "o", "t"))); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef" , List.of("ee", "eee", "eeee", "eeeee", "eeeeee"))); // false

    }

    private static boolean canConstruct(final String targetString, final List<String> strings) {
        final int size = targetString.length() + 1;
        boolean[] table = new boolean[size];
        table[0] = true;
        for (int i = 0; i < table.length; i++) {
            if (table[i]) {
                for (final String string : strings) {
                    final int position = i + string.length();
                    if (targetString.startsWith(string, i) && table.length > position) {
                        table[position] = true;
                    }
                }
            }
        }
        return table[targetString.length()];
    }
}
