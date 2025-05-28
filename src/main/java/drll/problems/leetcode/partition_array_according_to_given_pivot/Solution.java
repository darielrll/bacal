package drll.problems.leetcode.partition_array_according_to_given_pivot;

public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] pivotArray = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int forward = 0; forward < nums.length; forward++){
            if(nums[forward] < pivot){
                pivotArray[left++] = nums[forward];
            }
            int backward = nums.length - 1 - forward;
            if(pivot < nums[backward]){
                pivotArray[right--] = nums[backward];
            }
        }
        while(left <= right){
            pivotArray[left++] = pivot;
        }

        return pivotArray;
    }
}