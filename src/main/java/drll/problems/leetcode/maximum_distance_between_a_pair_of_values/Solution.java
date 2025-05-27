package drll.problems.leetcode.maximum_distance_between_a_pair_of_values;

public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance = 0;
        int lastCoverPosition = Math.min(nums1.length, nums2.length);
        for(int i = 0, nums2Index = 0; i < lastCoverPosition  &&  nums2Index < nums2.length; i++){
            nums2Index = lessThanToTheRight(nums2, nums1[i], Math.max(i, nums2Index), nums2.length - 1);
            if(nums2Index - i > maxDistance){
                maxDistance = nums2Index - i;
            }
        }

        return maxDistance;
    }

    private int lessThanToTheRight(int[] nums, int target, int init, int end){
        if(init > end){
            return -1;
        }
        int middle = (init + end) / 2;
        if(nums[middle] >= target){
            return Math.max(middle, lessThanToTheRight(nums, target, middle + 1, end));
        }
        return lessThanToTheRight(nums, target, init, middle - 1);
    }
}