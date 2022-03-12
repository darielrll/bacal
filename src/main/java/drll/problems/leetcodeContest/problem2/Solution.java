package drll.problems.leetcodeContest.problem2;

import java.util.Arrays;

public class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long minimalKSum = 0;

//        long currentValue = 1;
//        for (int i = 0; i < k; i++) {
//            while(contains(nums, currentValue, 0, nums.length - 1)){
//                currentValue++;
//            }
//            minimalKSum += currentValue++;
//        }

        int startRange = 1;
        int kSumCount = 0;
        for (int endRangePosition = 0; endRangePosition < nums.length; endRangePosition++) {
            if(startRange == nums[endRangePosition]){
                startRange++;
            }
            else {
                if(startRange < nums[endRangePosition]){
                    minimalKSum += sumatoria(nums[endRangePosition]) - sumatoria(startRange) - nums[endRangePosition] + startRange;
                    kSumCount += nums[endRangePosition] - 1 - startRange;
                    if(kSumCount == k){
                        return minimalKSum;
                    }

//                    for (int j = startRange; j < nums[endRangePosition]; j++) {
//                        if(kSumCount == k){
//                            return minimalKSum;
//                        }
//                        kSumCount++;
//                        minimalKSum += j;
//                    }
                    startRange = nums[endRangePosition] + 1;
                }
            }
        }

        while(kSumCount++ != k){
            minimalKSum += startRange++;
        }

        return minimalKSum;
    }

    private long sumatoria(int num) {
        return num * (num + 1) / 2;
    }

    private boolean contains(int[] nums, long currentValue, int start, int end) {
        if(start > end){
            return false;
        }
        int middlePosition = (start + end) / 2;
        if(nums[middlePosition] == currentValue){
            return true;
        }
        if(currentValue < nums[middlePosition]){
            return contains(nums, currentValue, start, middlePosition - 1);
        }
        return contains(nums, currentValue, middlePosition + 1, end);
    }
}