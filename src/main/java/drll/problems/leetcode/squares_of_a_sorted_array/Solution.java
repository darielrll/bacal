package drll.problems.leetcode.squares_of_a_sorted_array;

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