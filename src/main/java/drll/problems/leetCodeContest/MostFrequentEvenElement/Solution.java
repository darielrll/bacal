package drll.problems.leetCodeContest.MostFrequentEvenElement;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                if (map.containsKey(num)) {
                    map.replace(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
        }

        int maxRepetition = -1;
        int even = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == maxRepetition  &&  entry.getKey() < even){
                even = entry.getKey();
            }
            if(entry.getValue() > maxRepetition){
                maxRepetition = entry.getValue();
                even = entry.getKey();
            }
        }

        return even;
    }
}