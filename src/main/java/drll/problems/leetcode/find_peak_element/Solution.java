package drll.problems.leetcode.find_peak_element;

public class Solution {
    public int findPeakElement(int[] nums) {
        int peak = Integer.MIN_VALUE;
        int peakPosition = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > peak){
                peak = nums[i];
                peakPosition = i;
            }
        }
        return peakPosition;
    }
}
