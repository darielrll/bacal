package drll.problems.leetcode.rotateArray;

import java.util.HashMap;

public class Solution {
    public void rotate(int[] nums, int k) {
        int rotations = k % nums.length;
        if(rotations == 0){
            return;
        }
        HashMap<Integer, Integer> memory = new HashMap<>();
        for (int i = 0, length = nums.length; i < length; i++) {
            int targetPosition = (i + rotations) % length;
            memory.put(targetPosition, nums[targetPosition]);
            if (i >= rotations) {
                nums[targetPosition] = memory.get(i);
            } else {
                nums[targetPosition] = nums[i];
            }
        }
    }
}