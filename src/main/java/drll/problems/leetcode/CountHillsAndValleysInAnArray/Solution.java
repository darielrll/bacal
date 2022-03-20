package drll.problems.leetcode.CountHillsAndValleysInAnArray;

public class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if(isSameValley(nums, i - 1, i)){
                continue;
            }
            int leftNeighbor = nums[i - 1];

            int findRightNeighborPosition = i + 1;
            while (findRightNeighborPosition < nums.length - 1  && isSameValley(nums, findRightNeighborPosition, i)){
                findRightNeighborPosition++;
            }
            int rightNeighbor = nums[findRightNeighborPosition];

            if(isHill(leftNeighbor, rightNeighbor, nums[i])  ||  isValley(leftNeighbor, rightNeighbor, nums[i])){
                count++;
            }
        }

        return count;
    }

    private boolean isValley(int leftNeighbor, int rightNeighbor, int nums) {
        return leftNeighbor > nums && nums < rightNeighbor;
    }

    private boolean isHill(int leftNeighbor, int rightNeighbor, int nums) {
        return leftNeighbor < nums && nums > rightNeighbor;
    }

    private boolean isSameValley(int[] nums, int findRightNeighborPosition, int i) {
        return nums[findRightNeighborPosition] == nums[i];
    }
}