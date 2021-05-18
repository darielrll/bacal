package drll.problems.leetcode.uniquePaths;

import java.util.Arrays;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] pathsCount = new int[m][n];

        fillFirstRowCol(pathsCount);

        for (int i = 1; i < pathsCount.length; i++) {
            for (int j = 1; j < pathsCount[0].length; j++) {
                int upperPathCount = pathsCount[i - 1][j];
                int leftPathCount = pathsCount[i][j - 1];

                pathsCount[i][j] = upperPathCount + leftPathCount;
            }
        }

        return pathsCount[pathsCount.length - 1][pathsCount[0].length - 1];
    }

    private void fillFirstRowCol(int[][] pathsCount){
        Arrays.fill(pathsCount[0], 1);
        for (int i = 0; i < pathsCount.length; i++) {
            pathsCount[i][0] = 1;
        }
    }
}