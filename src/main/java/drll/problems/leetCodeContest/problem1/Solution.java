package drll.problems.leetCodeContest.problem1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        if(flush(suits)){
            return "Flush";
        } else if (theSameOfAKind(ranks, 3)) {
            return "Three of a Kind";
        } else if (theSameOfAKind(ranks, 2)) {
            return "Pair";
        }
        return "High Card";
    }

    private boolean flush(char[] suits) {
        for (int i = 1; i < suits.length; i++) {
            if(suits[i - 1] != suits[i]){
                return false;
            }
        }
        return true;
    }

    private boolean theSameOfAKind(int[] ranks, int count) {
        HashMap<Integer, Integer> ranksCount = new HashMap<>();
        for (int currentRank : ranks) {
            if (ranksCount.containsKey(currentRank)) {
                ranksCount.replace(currentRank, ranksCount.get(currentRank) + 1);
            } else {
                ranksCount.put(currentRank, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : ranksCount.entrySet()){
            if(entry.getValue() >= count){
                return true;
            }
        }
        return false;
    }

}