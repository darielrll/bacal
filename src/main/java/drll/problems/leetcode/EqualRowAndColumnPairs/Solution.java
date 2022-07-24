package drll.problems.leetcode.EqualRowAndColumnPairs;

import java.util.*;

public class Solution {
    public int equalPairs(int[][] grid) {

        HashMap<Long, Integer> rowValues = new HashMap<>();

        // row sum values
        int length = grid.length;
        for (int[] row : grid) {
            long rowSum = 0L;
            for (int col = 0; col < length; col++) {
                rowSum += row[col] * getPow(col);
            }

            if (rowValues.containsKey(rowSum)) {
                rowValues.replace(rowSum, rowValues.get(rowSum) + 1);
            } else {
                rowValues.put(rowSum, 1);
            }
        }

        int pairs = 0;
        // col sum values
        for (int row = 0; row < length; row++) {
            long colSum = 0L;
            for (int col = 0; col < length; col++) {
                colSum += grid[col][row] * getPow(col);
            }

            if(rowValues.containsKey(colSum)){
                pairs += rowValues.get(colSum);
            }
        }

        return pairs;
    }

    private long getPow(int col) {
        long pow = 1L;

        while (col-- > 0){
            pow *= 10;
        }

        return pow;
    }
}