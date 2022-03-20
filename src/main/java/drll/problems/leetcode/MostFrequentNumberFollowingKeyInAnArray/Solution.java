package drll.problems.leetcode.MostFrequentNumberFollowingKeyInAnArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++){
            if(nums[i] == key){
                int target = nums[i + 1];
                if(count.containsKey(target)){
                    count.put(target, count.get(target) + 1);
                }
                else {
                    count.put(target, 1);
                }
            }
        }

        int mostFrequentCount = 0;
        int mostFrequent = 0;
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            if(entry.getValue() > mostFrequentCount){
                mostFrequentCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        return mostFrequent;
    }
}