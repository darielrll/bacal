package drll.problems.leetcode.squaresOfASortedArray;

import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0, length = nums.length; i < length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}