package drll.problems.leetCodeContest.problem1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0){
                if(map.containsKey(nums[i])){
                    map.replace(nums[i], map.get(nums[i]) + 1);
                }
                else{
                    map.put(nums[i], 1);
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