package drll.problems.leetcode.sorting_the_sentence;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public String sortSentence(String s) {
        String[] wordArray = s.split(" ");
        List<String> strings = Arrays.asList(wordArray);
        strings.sort((word1, word2) -> {
            Integer word1Position = Integer.parseInt(String.valueOf(word1.charAt(word1.length() - 1)));
            Integer word2Position = Integer.parseInt(String.valueOf(word2.charAt(word2.length() - 1)));
            return word1Position.compareTo(word2Position);
        });
        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = wordArray[i].substring(0, wordArray[i].length() - 1);
        }

        return String.join(" ", wordArray);
    }
}