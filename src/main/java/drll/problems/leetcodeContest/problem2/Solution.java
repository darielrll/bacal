package drll.problems.leetcodeContest.problem2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] shuffledDecimals = shuffledDecimals(mapping, nums);
        Map<Integer, Integer> mapped = collectMapping(nums, shuffledDecimals);

        int[] test = {6, 5, 4, 3, 2, 1};
        int[] mergedNumbers = mergeSort(test, 0, test.length - 1 );

        Arrays.sort(shuffledDecimals);


        int[] sortJumbled = new int[nums.length];

        for (int i = 0; i < shuffledDecimals.length; i++) {
            sortJumbled[i] = mapped.get(shuffledDecimals[i]);
        }

        return sortJumbled;
    }

    private int[] mergeSort(int[] nums, int start, int end) {
        if(start == end){
            return new int[]{nums[start]};
        }
        int middle = (start + end) / 2;
        int[] leftSide = mergeSort(nums, start, middle);
        int[] rightSide = mergeSort(nums, middle + 1, end);
        return merge(leftSide, rightSide);
    }

    private int[] merge(int[] leftSide, int[] rightSide) {
        int[] ordered = new int[leftSide.length + rightSide.length];

        int pointLeft = 0;
        int pointRight = 0;
        int pointOrdered = 0;

        while(pointLeft < leftSide.length  &&  pointRight < rightSide.length){
            if (leftSide[pointLeft] < rightSide[pointRight]) {
                ordered[pointOrdered] = leftSide[pointLeft];
                pointLeft++;
            }
            else{
                ordered[pointOrdered] = rightSide[pointRight];
                pointRight++;
            }
            pointOrdered++;
        }

        if(pointLeft < leftSide.length){
            for (int i = pointLeft; i < leftSide.length; i++) {
                ordered[pointOrdered++] = leftSide[pointLeft];
            }
        }
        else{
            for (int i = pointRight; i < rightSide.length; i++) {
                ordered[pointOrdered++] = rightSide[pointRight];
            }
        }

        return ordered;
    }

    private Map<Integer, Integer> collectMapping(int[] nums, Integer[] shuffledDecimals) {
        Map<Integer, Integer> mapped = new HashMap<>();

        for (int i = 0; i < shuffledDecimals.length; i++) {
            if (!mapped.containsKey(shuffledDecimals[i])) {
                mapped.put(shuffledDecimals[i], nums[i]);
            }
        }

        return mapped;
    }

    public Integer[] shuffledDecimals(int[] mapping, int[] nums){
        Integer[] shuffledDecimals = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            shuffledDecimals[i] = convertToShuffled(mapping, nums[i]);
        }

        return shuffledDecimals;
    }

    private int convertToShuffled(int[] mapping, int num) {
        char[] numString = String.valueOf(num).toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char c : numString) {
            builder.append(mapping[Integer.parseInt(String.valueOf(c))]);
        }


        return Integer.valueOf(builder.toString());
    }
}
