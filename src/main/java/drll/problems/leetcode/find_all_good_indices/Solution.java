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

            if (nonIncreasingPositionBreak == -1 && nonDecreasingPositionBreak == -1) {
                goodIndices.add(candidateGoodIndex);
                candidateGoodIndex++;

                if(candidateGoodIndex < nums.length - k){
                    verifyBefore = nums[candidateGoodIndex - 1] > nums[candidateGoodIndex - 2];
                    verifyAfter = verifyBefore;
                    boolean isAfterNonDecreasingBroken = nums[candidateGoodIndex + k] < nums[candidateGoodIndex + k - 1];

                    candidateGoodIndex = getCandidateGoodIndex(k, verifyBefore, isAfterNonDecreasingBroken, candidateGoodIndex);
                    verifyBefore = isVerifyBefore(isAfterNonDecreasingBroken, verifyBefore);
                }
            }
            else {
                candidateGoodIndex = nonIncreasingPositionBreak != -1
                        ? nonIncreasingPositionBreak + k + 1
                        : nonDecreasingPositionBreak;
            }
        }
        return goodIndices;
    }

    private static boolean isVerifyBefore(boolean isAfterNonDecreasingBroken, boolean verifyBefore) {
        if(isAfterNonDecreasingBroken){
            return true;
        }
        return verifyBefore;
    }

    private static int getCandidateGoodIndex(int k, boolean verifyBefore, boolean isAfterNonDecreasingBroken, int candidateGoodIndex) {
        if(verifyBefore || isAfterNonDecreasingBroken){
            return candidateGoodIndex + k - 1;
        }
        return candidateGoodIndex;
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