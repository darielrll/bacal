package drll.problems.leetcode.sort_integers_by_the_power_value;

import java.util.*;

public class Solution {
    public int getKth(int lo, int hi, int k) {
        int[][] numberPowerSteps = new int[hi - lo + 1][2];
        Map<Integer, Integer> history = new HashMap<>();

        for (int i = lo; i <= hi; i++) {
            numberPowerSteps[i - lo][0] = i;
            numberPowerSteps[i - lo][1] = getPowerValue(i, history);
        }

        Arrays.sort(numberPowerSteps, Comparator.comparingInt(pair -> pair[1]));

        return numberPowerSteps[k - 1][0];
    }

    public int getPowerValue(int number, Map<Integer, Integer> history) {
        if(number == 1){
            return 0;
        }
        if(history.containsKey(number)) {
            return history.get(number);
        }
        if(number % 2 == 0) {
            history.put(number, 1 + getPowerValue(number / 2, history));
        }
        else{
            history.put(number, 1 + getPowerValue(3 * number + 1, history));
        }
        return history.get(number);
    }
}