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
            int beforeStart =  candidateGoodIndex - k;
            int beforeEnd = candidateGoodIndex - 1;

            int afterStart = candidateGoodIndex + 1;
            int afterEnd = candidateGoodIndex + k;

            int nonIncreasingPositionBreak = getNonIncreasingPositionBreak(verifyBefore, checkNonIncreasing(nums, beforeStart, beforeEnd));
            int nonDecreasingPositionBreak = getNonIncreasingPositionBreak(verifyAfter, checkNonDecreasing(nums, afterStart, afterEnd));

            if (nonIncreasingPositionBreak != -1) {
                candidateGoodIndex = nonIncreasingPositionBreak + k + 1;
            } else if (nonDecreasingPositionBreak != -1) {
                candidateGoodIndex = nonDecreasingPositionBreak;
            } else {
                goodIndices.add(candidateGoodIndex);
                candidateGoodIndex++;

                if(candidateGoodIndex >= nums.length - k){
                    break;
                }

                if(nums[beforeEnd + 1] > nums[beforeEnd]){
                    verifyBefore = true;
                    verifyAfter = true;
                    candidateGoodIndex = beforeEnd + k + 1;
                }
                else{
                    verifyBefore = false;
                    verifyAfter = false;
                    if(nums[afterEnd + 1] < nums[afterEnd]){
                        verifyBefore = true;
                        candidateGoodIndex = afterEnd;
                    }
                }
            }
        }
        return goodIndices;
    }

    private int getNonIncreasingPositionBreak(boolean verifyBefore, int nums) {
        return verifyBefore ? nums : -1;
    }

    private int checkNonIncreasing(int[] nums, int start, int end){
        for (int i = start; i < end; i++) {
            if(nums[i] < nums[i + 1]){
                return i;
            }
        }
        return -1;
    }

    private int checkNonDecreasing(int[] nums, int start, int end){
        for (int i = start; i < end; i++) {
            if(nums[i] > nums[i + 1]){
                return i;
            }
        }
        return -1;
    }
}