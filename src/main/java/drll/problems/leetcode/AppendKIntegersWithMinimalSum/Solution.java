package drll.problems.leetcode.AppendKIntegersWithMinimalSum;

import java.util.Arrays;

public class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        long minimalKSum = 0;
        int startRange = 1;
        int partialSumCount = 0;

        for (int i = 0; i < nums.length  && partialSumCount + (nums[i] - startRange) <= k; i++) {
            int currentNumber = nums[i];
            if (startRange != currentNumber) {
                if (startRange < currentNumber) {
                    minimalKSum += getPartialMinimalKSum(startRange, currentNumber);
                    partialSumCount += currentNumber - startRange;
                    startRange = currentNumber + 1;
                }
            } else {
                startRange++;
            }
        }

        return minimalKSum + getPartialMinimalKSum(startRange, startRange + (k - partialSumCount));
    }

    private long getPartialMinimalKSum(int startRange, int endRangePosition) {
        return (long) (endRangePosition - startRange) * (endRangePosition + startRange - 1) / 2;
    }
}