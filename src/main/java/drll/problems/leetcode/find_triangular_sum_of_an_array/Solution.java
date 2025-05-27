package drll.problems.leetcode.find_triangular_sum_of_an_array;

public class Solution {
    public int triangularSum(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] numsDown = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            numsDown[i] = (nums[i] + nums[i + 1]) % 10;
        }
        return triangularSum(numsDown);
    }
}