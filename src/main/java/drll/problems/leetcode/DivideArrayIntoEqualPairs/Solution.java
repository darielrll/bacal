package drll.problems.leetcode.DivideArrayIntoEqualPairs;

import java.util.Arrays;

public class Solution {
    public boolean search(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if(nums[i] != nums[i + 1]){
                return false;
            }
        }
        return true;
    }
}