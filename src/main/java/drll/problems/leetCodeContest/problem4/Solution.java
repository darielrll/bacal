package drll.problems.leetCodeContest.problem4;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        Number[] numbers = new Number[nums.length + 1];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = new Number(nums[i], i);
            if(max < nums[i]){
                max = nums[i];
            }
        }
        numbers[numbers.length - 1] = new Number(max + 1, numbers.length - 1);

        Arrays.sort(numbers, Comparator.comparingInt(o -> o.value));
        int sequenceCount = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            Number number = numbers[i];
            Number numberNext = numbers[i + 1];

            if(number.value < numberNext.value &&
                number.position < numberNext.position){
                sequenceCount++;
            }
        }

        return sequenceCount;
    }
}

class Number{
    int value;
    int position;

    public Number(int numbers, int position) {
        this.value = numbers;
        this.position = position;
    }
}