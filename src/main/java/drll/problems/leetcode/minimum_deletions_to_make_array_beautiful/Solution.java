package drll.problems.leetcode.minimum_deletions_to_make_array_beautiful;

public class Solution {
    public int minDeletion(int[] nums) {
        int deletions = 0;

        int adjacent = 1;
        int controlEven = 0;
        while (controlEven < nums.length - 1  &&  adjacent < nums.length) {
            if (nums[controlEven] == nums[adjacent]) {
                deletions++;
                adjacent++;
            } else {
                controlEven = adjacent + 1;
                adjacent = controlEven + 1;
            }
        }

        return (nums.length - deletions) % 2 == 0
                ? deletions : deletions + 1;
    }
}