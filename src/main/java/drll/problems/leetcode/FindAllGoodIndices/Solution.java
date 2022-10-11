package drll.problems.leetcode.FindAllGoodIndices;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> goodIndices = new ArrayList<>();

        int candidateGoodIndex = k;

        int beforeStart, beforeEnd, afterStart, afterEnd;

        boolean verifyBefore = true;
        boolean verifyAfter = true;

        while (candidateGoodIndex < nums.length - k){
            beforeStart =  candidateGoodIndex - k;
            beforeEnd = candidateGoodIndex - 1;

            afterStart = candidateGoodIndex + 1;
            afterEnd = candidateGoodIndex + k;

            int nonIncreasingPositionBreak = verifyBefore
                    ? checkNonIncreasing(nums, beforeStart, beforeEnd)
                    : -1;
            int nonDecreasingPositionBreak = verifyAfter
                    ? checkNonDecreasing(nums, afterStart, afterEnd)
                    : -1;

            if (nonIncreasingPositionBreak != -1 || nonDecreasingPositionBreak != -1) {
                candidateGoodIndex = nonIncreasingPositionBreak != -1
                        ? nonIncreasingPositionBreak + k + 1
                        : nonDecreasingPositionBreak;
            }
            else {
                goodIndices.add(candidateGoodIndex);
                candidateGoodIndex++;

                if(candidateGoodIndex >= nums.length - k){
                    break;
                }

                verifyBefore = true;
                verifyAfter = true;

                if(nums[beforeEnd + 1] > nums[beforeEnd]){
                    candidateGoodIndex = beforeEnd + k + 1;
                }
                else{
                    verifyBefore = false;
                    if(nums[afterEnd + 1] < nums[afterEnd]){
                        verifyBefore = true;
                        candidateGoodIndex = afterEnd;
                    }
                    verifyAfter = false;
                }
            }
        }
        return goodIndices;
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