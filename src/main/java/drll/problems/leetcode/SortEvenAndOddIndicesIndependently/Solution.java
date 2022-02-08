package drll.problems.leetcode.SortEvenAndOddIndicesIndependently;

import java.util.Arrays;

public class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int[] oddIndex = new int[nums.length / 2];
        int[] evenIndex = new int[nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1];

        for (int i = 1; i < nums.length; i += 2){
            oddIndex[i/2] = nums[i];
        }
        for (int i = 0; i < nums.length; i += 2){
            evenIndex[i/2] = nums[i];
        }
        Arrays.sort(oddIndex);
        Arrays.sort(evenIndex);

        int[] sortEvenOdd = new int[nums.length];
        for (int i = oddIndex.length - 1; i >= 0; i--){
            sortEvenOdd[(oddIndex.length - i - 1) * 2 + 1] = oddIndex[i];
        }
        for (int i = 0; i < evenIndex.length; i++){
            sortEvenOdd[i * 2] = evenIndex[i];
        }

        return sortEvenOdd;
    }
}