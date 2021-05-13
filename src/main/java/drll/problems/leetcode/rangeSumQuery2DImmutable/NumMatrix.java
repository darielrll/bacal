package drll.problems.leetcode.rangeSumQuery2DImmutable;

public class NumMatrix {
    private final int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        sumMatrix = buildSumMatrix(matrix);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1]
                - sumMatrix[row1][col2 + 1]
                - sumMatrix[row2 + 1][col1]
                + sumMatrix[row1][col1];
    }

    private int[][] buildSumMatrix(int[][] matrix) {
        int[][] sums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                sums[row + 1][col + 1] = matrix[row][col]
                        + sums[row][col + 1]
                        + sums[row + 1][col]
                        - sums[row][col];
            }
        }
        return sums;
    }
}