package drll.problems.leetcode.counting_words_with_a_given_prefix;

import java.util.Arrays;

public class Solution {
    public int prefixCount(String[] words, String pref) {
        return (int) Arrays.stream(words).filter(word -> word.startsWith(pref)).count();
    }
}