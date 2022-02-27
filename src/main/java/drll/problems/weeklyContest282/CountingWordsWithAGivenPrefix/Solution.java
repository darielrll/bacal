package drll.problems.weeklyContest282.CountingWordsWithAGivenPrefix;

import java.util.Arrays;

public class Solution {
    public int prefixCount(String[] words, String pref) {
        return (int) Arrays.stream(words).filter(word -> word.startsWith(pref)).count();
    }
}