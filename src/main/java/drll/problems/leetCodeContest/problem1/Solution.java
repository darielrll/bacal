package drll.problems.leetCodeContest.problem1;

import java.net.Inet4Address;
import java.util.*;

public class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> retMap = new HashMap<>();
        for (int i = 0; i < items1.length; i++) {
            int value = items1[i][0];
            if(retMap.containsKey(value)){
                retMap.replace(value, retMap.get(value) + items1[i][1]);
            }
            else{
                retMap.put(value, items1[i][1]);
            }
        }
        for (int i = 0; i < items2.length; i++) {
            int value = items2[i][0];
            if(retMap.containsKey(value)){
                retMap.replace(value, retMap.get(value) + items2[i][1]);
            }
            else{
                retMap.put(value, items2[i][1]);
            }
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : retMap.entrySet()) {
            List<Integer> itemValue = new ArrayList<>();
            itemValue.add(entry.getKey());
            itemValue.add(entry.getValue());
            ret.add(itemValue);
        }

        ret.sort(Comparator.comparing(o -> o.get(0)));

        return ret;
    }
}