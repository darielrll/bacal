package drll.problems.leetcode.minimumSumOfFourDigitNumberAfterSplittingDigits;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumSum(int num) {
        List<String> numberCombinations = new ArrayList<>();
        char[] characters = String.valueOf(num).toCharArray();
        getCombinations(characters, new boolean[characters.length], "", numberCombinations);

        int minimumSum = Integer.MAX_VALUE;
        for (String combination : numberCombinations) {
            for (int j = 1, length = combination.length(); j < length; j++) {
                minimumSum = Integer.min(minimumSum,
                        Integer.parseInt(combination.substring(0, j)) +
                                Integer.parseInt(combination.substring(j)));
            }
        }
        return minimumSum;
    }

    private void getCombinations(char[] characters, boolean[] visited, String combination, List<String> combinations) {
        if (combination.length() == characters.length) {
            combinations.add(combination);
        }
        for (int i = 0; i < characters.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                getCombinations(characters, visited, combination + characters[i], combinations);
                visited[i] = false;
            }
        }
    }
}