package drll.problems.leetcode.FindAllKDistantIndicesInAnArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> kDistants = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int start = i - k;
                if(start < 0){
                    start = 0;
                }
                for (int j = start; j >= 0  &&  j <= i + k  &&  j < nums.length; j++) {
                    kDistants.add(j);
                }
            }
        }
        List<Integer> a = new ArrayList<>(kDistants);
        a.sort(Integer::compareTo);
        return a;
    }
}