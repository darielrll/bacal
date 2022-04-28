package drll.problems.leetcode.IntersectionOfMultipleArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> intersection = new ArrayList<>();
        HashMap<Integer, Integer> repeat = new HashMap<>();

        for (int[] num : nums) {
            for (int i : num) {
                if (repeat.containsKey(i)) {
                    repeat.replace(i, repeat.get(i) + 1);
                } else {
                    repeat.put(i, 1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry :
                repeat.entrySet()) {
            if(entry.getValue() == nums.length){
                intersection.add(entry.getKey());
            }
        }

        intersection.sort(Integer::compareTo);

        return intersection;
    }
}