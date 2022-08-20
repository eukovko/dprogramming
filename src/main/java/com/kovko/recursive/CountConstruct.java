package com.kovko.recursive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountConstruct {


    public static void main(String[] args) {
        System.out.println(countConstruct("purple", List.of("purp", "p", "ur", "le", "purpl"))); // 2
        System.out.println(countConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd"))); // 1
        System.out.println(countConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar"))); // 0
        System.out.println(countConstruct("enterapotentpot", List.of( "a", "p", "ent", "enter", "ot", "o", "t"))); // 4
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee"))); // 0
    }

    private static int countConstruct(final String string, final List<String> wordBank) {
        return countConstruct(string, wordBank, new HashMap<>());
    }
    private static int countConstruct(final String string, final List<String> wordBank, final Map<String, Integer> memo) {

        if (memo.containsKey(string)) {
            return memo.get(string);
        }

        if (string.isEmpty()) {
            return 1;
        }

        final int result = wordBank.stream()
            .filter(string::startsWith)
            .map(s -> string.substring(s.length()))
            .mapToInt(s -> countConstruct(s, wordBank, memo))
            .sum();

        memo.put(string, result);

        return result;
    }

}
