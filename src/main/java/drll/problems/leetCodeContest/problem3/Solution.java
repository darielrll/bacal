package drll.problems.leetCodeContest.problem3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> goodIndices = new ArrayList<>();

        int candidateGoodIndex = k;

        int beforeStart = candidateGoodIndex - k;
        int beforeEnd = beforeStart + k - 1;

        int afterStart = k + 1;
        int afterEnd = afterStart + k - 1;

        boolean verifyBefore = true;
        boolean verifyAfter = true;

        while (candidateGoodIndex < nums.length - k){
            int nonIncreasingPositionBreak = verifyBefore
                    ? checkNonIncreasing(nums, beforeStart, beforeEnd)
                    : -1;
            int nonDecreasingPositionBreak = verifyAfter
                    ? checkNonDecreasing(nums, afterStart, afterEnd)
                    : -1;

            if(nonIncreasingPositionBreak != -1){
                beforeStart =  nonIncreasingPositionBreak + 1;
                beforeEnd = beforeStart + k - 1;

                afterStart = beforeEnd + 2;
                afterEnd = afterStart + k - 1;

                candidateGoodIndex = beforeEnd + 1;
                verifyAfter = true;
                continue;
            }
            if(nonDecreasingPositionBreak != -1 ){
                afterStart = nonDecreasingPositionBreak + 1;
                afterEnd = afterStart + k - 1;

                beforeEnd = afterStart - 2;
                beforeStart = beforeEnd - k + 1;

                candidateGoodIndex = beforeEnd + 1;
                verifyBefore = true;
                continue;
            }

            goodIndices.add(candidateGoodIndex);
            candidateGoodIndex++;

            if(candidateGoodIndex >= nums.length - k){
                break;
            }

            beforeStart++;
            beforeEnd++;
            if(nums[beforeEnd] > nums[beforeEnd - 1]){
                verifyBefore = true;

                beforeStart = beforeEnd;
                beforeEnd = beforeStart + k - 1;

                afterStart = beforeEnd + 2;
                afterEnd = afterStart + k - 1;

                candidateGoodIndex = beforeEnd + 1;

                continue;
            }
            else{
                verifyBefore = false;
            }

            afterStart++;
            afterEnd++;
            if(nums[afterEnd] < nums[afterEnd - 1]){
                verifyAfter = true;

                afterStart = afterEnd;
                afterEnd = afterStart + k - 1;

                beforeEnd = afterStart - 2;
                beforeStart = beforeEnd - k + 1;

                candidateGoodIndex = beforeEnd + 1;
            }
            else{
                verifyAfter = false;
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