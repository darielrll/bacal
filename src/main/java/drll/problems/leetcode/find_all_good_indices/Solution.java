package drll.problems.leetcode.find_all_good_indices;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> goodIndices = new ArrayList<>();

        int candidateGoodIndex = k;

        boolean verifyBefore = true;
        boolean verifyAfter = true;

        while (candidateGoodIndex < nums.length - k){

            int nonIncreasingPositionBreak = getNonIncreasingPositionBreak(verifyBefore, checkNonIncreasing(nums, candidateGoodIndex, k));
            int nonDecreasingPositionBreak = getNonIncreasingPositionBreak(verifyAfter, checkNonDecreasing(nums, candidateGoodIndex, k));

            if (nonIncreasingPositionBreak != -1) {
                candidateGoodIndex = nonIncreasingPositionBreak + k + 1;
            } else if (nonDecreasingPositionBreak != -1) {
                candidateGoodIndex = nonDecreasingPositionBreak;
            } else {
                goodIndices.add(candidateGoodIndex);
                candidateGoodIndex++;

                if(candidateGoodIndex < nums.length - k){
                    verifyBefore = nums[candidateGoodIndex - 1] > nums[candidateGoodIndex - 2];
                    verifyAfter = verifyBefore;
                    if(verifyBefore){
                        candidateGoodIndex += k - 1;
                    }
                    else{
                        if(nums[candidateGoodIndex + k] < nums[candidateGoodIndex + k - 1]){
                            verifyBefore = true;
                            candidateGoodIndex += k - 1;
                        }
                    }
                }
            }
        }
        return goodIndices;
    }

    private int getNonIncreasingPositionBreak(boolean verifyBefore, int nums) {
        return verifyBefore ? nums : -1;
    }

    private int checkNonIncreasing(int[] nums, int candidateGoodIndex, int k){
        int start =  candidateGoodIndex - k;
        int end = candidateGoodIndex - 1;

        for (int i = start; i < end; i++) {
            if(nums[i] < nums[i + 1]){
                return i;
            }
        }
        return -1;
    }

    private int checkNonDecreasing(int[] nums, int candidateGoodIndex, int k){
        int start = candidateGoodIndex + 1;
        int end = candidateGoodIndex + k;

        for (int i = start; i < end; i++) {
            if(nums[i] > nums[i + 1]){
                return i;
            }
        }
        return -1;
    }
}