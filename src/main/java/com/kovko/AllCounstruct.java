package com.kovko;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllCounstruct {

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

    private static List<List<String>> allConstruct(final String word, final List<String> wordBank) {
        return allConstruct(word, wordBank, new HashMap<>());
    }
    private static List<List<String>> allConstruct(final String word, final List<String> wordBank, Map<String, List<List<String>>> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        if (word.isEmpty()) {
            final List<List<String>> emptyResult = new ArrayList<>();
            emptyResult.add(new ArrayList<>());
            return emptyResult;
        }

        final List<List<String>> result = new ArrayList<>();
        for (final String s : wordBank) {
            if (word.startsWith(s)) {
                final List<List<String>> partialResult = allConstruct(word.substring(s.length()), wordBank, memo);
                for (final List<String> strings : partialResult) {
                    strings.add(0, s);
                    result.add(strings);
                }
            }
        }
        memo.put(word, result);
        return result;
    }
}
