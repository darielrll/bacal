package drll.problems.leetcode.make_array_zero_by_subtracting_equal_amounts;

import java.util.Arrays;

public class Solution {
    public int minimumOperations(int[] nums) {
        if(nums.length == 1){
            if(nums[0] == 0){
                return 0;
            }
            else {
                return 1;
            }
        }

        Arrays.sort(nums);

        int startPosition = 0;
        int operations = 0;
        while (startPosition < nums.length){
            int minimum = getMinimum(nums, startPosition);
            if(minimum == 0){
                return operations;
            }
            startPosition = decrease(nums, minimum, startPosition);
            if(startPosition <= nums.length){
                operations++;

            }
        }
        return  operations;
    }

    private int decrease(int[] nums, int minimum, int startPosition) {
        int nextStart = startPosition;
        for (int i = startPosition; i < nums.length; i++) {
            if(nums[i] > 0) {
                nums[i] -= minimum;
            }
            if (nums[i] == 0){
                nextStart = i;
            }
        }
        return nextStart;
    }

    private int getMinimum(int[] nums, int startPosition) {
        for (int i = startPosition; i < nums.length; i++) {
            if(nums[i] != 0){
                return nums[i];
            }
        }
        return 0;
    }
}