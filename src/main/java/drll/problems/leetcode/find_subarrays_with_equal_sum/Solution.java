package drll.problems.leetcode.find_subarrays_with_equal_sum;

public class Solution {
    public boolean findSubarrays(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            for (int j = i + 1; j < nums.length - 1; j++) {
                if(sum == nums[j] + nums[j + 1]){
                    return true;
                }
            }
        }
        return false;
    }
}