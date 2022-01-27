
package drll.problems.leetcode.moveZeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        int numPosition = 0;
        for (int i = 0, length = nums.length; i < length; i++){
            if(nums[i] == 0){
                continue;
            }
            nums[numPosition++] = nums[i];
        }
        for (int i = numPosition, length = nums.length; i < length; i++){
            nums[i] = 0;
        }
    }
}