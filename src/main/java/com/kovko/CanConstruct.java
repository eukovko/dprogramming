package com.kovko;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanConstruct {

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", List.of("ab" , "abc" , "cd", "def" , "abcd"))); // true
        System.out.println(canConstruct("skateboard", List.of("bo" , "rd" , "ate" , "t" , "ska" , "sk" , "boar"))); // false
        System.out.println(canConstruct("enterapotentpot" , List.of("a", "p", "ent", "enter", "ot", "o", "t"))); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef" , List.of("ee", "eee", "eeee 7", "eeeee", "eeeeee"))); // false

    }

    private static boolean canConstruct(String target, List<String> strings) {
        return canConstruct(target, strings, new HashMap<>());
    }
    private static boolean canConstruct(String target, List<String> strings, Map<String, Boolean> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.isEmpty()) {
            return true;
        }
        for (final String string : strings) {
            if (target.startsWith(string)) {
                final int length = string.length();
                final String substring = target.substring(length);
                final boolean result = canConstruct(substring, strings);
                memo.put(target, result);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }
}
