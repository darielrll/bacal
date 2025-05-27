package drll.problems.leetcode.largest_local_values_in_a_matrix;

public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] maxLocal = new int[grid.length - 2][grid.length - 2];

        for (int i = 0; i < maxLocal.length; i++) {
            for (int j = 0; j < maxLocal.length; j++) {
                maxLocal[i][j] = getMaxLocal(grid, i, j);
            }
        }

        return maxLocal;
    }

    private int getMaxLocal(int[][] grid, int r, int c) {
        int max = -1;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if(max < grid[i][j]){
                    max = grid[i][j];
                }
            }
        }

        return max;
    }
}