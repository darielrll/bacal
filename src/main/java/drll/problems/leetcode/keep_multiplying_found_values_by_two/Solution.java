package drll.problems.leetcode.keep_multiplying_found_values_by_two;

import java.util.Arrays;

public class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);

        int mostOriginal = original;
        int originalPosition = search(nums, mostOriginal, 0, nums.length - 1);
        while (originalPosition != -1){
            mostOriginal = mostOriginal * 2;
            originalPosition = search(nums, mostOriginal, 0, nums.length - 1);
        }
        return mostOriginal;
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middlePosition = (start + end) / 2;
        if(nums[middlePosition] == target){
            return middlePosition;
        }
        return nums[middlePosition] > target
                ? search(nums, target, start, middlePosition - 1)
                : search(nums, target, middlePosition + 1, end);
    }
}