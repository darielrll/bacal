package drll.problems.leetcode.nonDecreasingArray;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        int fistAscPosition = -1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i - 1] > nums[i]){
                if(fistAscPosition == -1){
                    fistAscPosition = i - 1;
                }
                else{
                    return false;
                }
            }
        }
        if(fistAscPosition == -1){
            return true;
        }
        int secondAscPosition = nums.length - 1;

        return canUpload(fistAscPosition, secondAscPosition, nums)  ||
                canDown(fistAscPosition, nums);
    }

    private boolean canUpload(int fistAscPosition, int secondAscPosition, int[] nums){
        int rightValuesToModify = secondAscPosition - fistAscPosition - 1;
        if(rightValuesToModify == 0){
            return true;
        }
        if(nums[fistAscPosition] <= nums[fistAscPosition + 2]){
            return true;
        }
        if(rightValuesToModify > 1){
            return false;
        }
        if(nums[fistAscPosition] < nums[secondAscPosition]){
            return true;
        }
        return false;
    }

    private boolean canDown(int fistAscPosition, int[] nums){
        if(fistAscPosition == 0){
            return true;
        }
        if(nums[fistAscPosition + 1] >= nums[fistAscPosition - 1]){
            return true;
        }
        return false;
    }
}