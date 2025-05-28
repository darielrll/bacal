package drll.problems.leetcode.search_insert_position;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return start;
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