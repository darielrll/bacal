package drll.problems.leetcode.findFirstAndLastPositionOfElementInSortedArray;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int targetPosition = targetPosition(nums, target, 0, nums.length - 1);
        if(targetPosition == -1){
            return new int[]{-1, -1};
        }
        int startingPosition = targetPosition;
        for(int i = targetPosition; i >= 0; i--){
            if(nums[i] == target){
                startingPosition = i;
            }
        }
        int endingPosition = targetPosition;
        for(int i = targetPosition; i < nums.length; i++){
            if(nums[i] == target){
                endingPosition = i;
            }
        }
        return new int[]{startingPosition, endingPosition};
    }

    private int targetPosition(int[] nums, int target, int init, int end){
        if(init > end){
            return -1;
        }
        int middlePosition = (init + end) / 2;
        if(nums[middlePosition] == target){
            return middlePosition;
        }
        if(target < nums[middlePosition]){
            return targetPosition(nums, target, init, middlePosition - 1);
        }
        return targetPosition(nums, target, middlePosition + 1, end);
    }
}
