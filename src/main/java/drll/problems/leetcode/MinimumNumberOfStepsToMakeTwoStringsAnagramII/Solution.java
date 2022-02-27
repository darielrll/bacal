package drll.problems.leetcode.MinimumNumberOfStepsToMakeTwoStringsAnagramII;

import java.util.HashMap;

public class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> sLetterCount = letterCounts(s);
        HashMap<Character, Integer> tLetterCount = letterCounts(t);

        reduceLetterCount(sLetterCount, t);
        reduceLetterCount(tLetterCount, s);

        return countLetterCount(sLetterCount) + countLetterCount(tLetterCount);
    }

    private int countLetterCount(HashMap<Character, Integer> letterCounts) {
        return letterCounts.values().stream().mapToInt(count -> count).sum();
    }

    private void reduceLetterCount(HashMap<Character, Integer> letterCounts, String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (letterCounts.containsKey(c)) {
                if (letterCounts.get(c) == 1) {
                    letterCounts.remove(c);
                } else {
                    letterCounts.put(c, letterCounts.get(c) - 1);
                }
            }
        }
    }

    private HashMap<Character, Integer> letterCounts(String s) {
        HashMap<Character, Integer> letterCounts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letterCounts.put(c, letterCounts.containsKey(c) ? letterCounts.get(c) + 1 : 1);
        }

        return letterCounts;
    }
}