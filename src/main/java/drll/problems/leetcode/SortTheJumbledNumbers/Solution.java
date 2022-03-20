package drll.problems.leetcode.SortTheJumbledNumbers;

public class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] shuffledDecimals = shuffledDecimals(mapping, nums);
        return mergeSortJumbled(shuffledDecimals, nums);
    }

    private int[] mergeSortJumbled(int[] shuffledDecimals, int[] nums){
        return mergeSort(shuffledDecimals, nums, 0, shuffledDecimals.length - 1)[1];
    }

    private int[][] mergeSort(int[] shuffledDecimals, int[] nums, int start, int end) {
        if(start == end){
            return new int[][]{
                    new int[]{shuffledDecimals[start]},
                    new int[]{nums[start]}
            };
        }
        int middle = (start + end) / 2;
        int[][] leftSide = mergeSort(shuffledDecimals, nums, start, middle);
        int[][] rightSide = mergeSort(shuffledDecimals, nums,middle + 1, end);
        return merge(leftSide, rightSide);
    }

    private int[][] merge(int[][] leftSide, int[][] rightSide) {
        int[][] ordered = new int[2][leftSide[0].length + rightSide[0].length];

        int pointLeft = 0;
        int pointRight = 0;
        int pointOrdered = 0;

        while(pointLeft < leftSide[0].length  &&  pointRight < rightSide[0].length){
            if (leftSide[0][pointLeft] <= rightSide[0][pointRight]) {
                ordered[0][pointOrdered] = leftSide[0][pointLeft];
                ordered[1][pointOrdered] = leftSide[1][pointLeft];
                pointLeft++;
            }
            else{
                ordered[0][pointOrdered] = rightSide[0][pointRight];
                ordered[1][pointOrdered] = rightSide[1][pointRight];
                pointRight++;
            }
            pointOrdered++;
        }

        if(pointLeft < leftSide[0].length){
            for (int i = pointLeft; i < leftSide[0].length; i++) {
                ordered[0][pointOrdered] = leftSide[0][i];
                ordered[1][pointOrdered] = leftSide[1][i];
                pointOrdered++;
            }
        }
        else{
            for (int i = pointRight; i < rightSide[0].length; i++) {
                ordered[0][pointOrdered] = rightSide[0][i];
                ordered[1][pointOrdered] = rightSide[1][i];
                pointOrdered++;
            }
        }

        return ordered;
    }

    public int[] shuffledDecimals(int[] mapping, int[] nums){
        int[] shuffledDecimals = new int[nums.length];

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

        return Integer.parseInt(builder.toString());
    }
}
