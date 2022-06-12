package drll.problems.leetCodeContest.problem2;

import java.util.Arrays;

public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];

        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int insertionPosition = insertionPosition(potions, 0, potions.length - 1, spells[i], success);
            if(insertionPosition == -1){
                pairs[i] = 0;
            }
            else {
                pairs[i] = potions.length - insertionPosition;
            }
        }

        return pairs;
    }

    private int insertionPosition(int[] numbers, int init, int end, int spell, long success){
        if(init == end){
            long currentPair = (long) spell * numbers[init];
            if(currentPair >= success){
                return init;
            }
            else{
                return -1;
            }
        }
        int middlePosition = (init + end) / 2;
        long currentPair = (long) spell * numbers[middlePosition];
        if(currentPair >= success){
            return insertionPosition(numbers, init, middlePosition, spell, success);
        }
        else{
            return insertionPosition(numbers, middlePosition + 1, end, spell, success);
        }
    }
}