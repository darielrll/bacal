package drll.problems.leetcode.compare_sums_of_bitonic_parts;

public class Solution {
    public int compareBitonicSums(int[] nums) {
        int peakIndex = 0;
        long sum = nums[peakIndex];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[peakIndex]) {
                sum += nums[i];
                peakIndex = i;
            }
        }
        sum -= nums[peakIndex];
        for (int i = peakIndex + 1; i < nums.length; i++) {
            sum -= nums[i];
            if (sum < 0) {
                return 1;
            }
        }
        return sum > 0 ? 0 : -1;
    }
}