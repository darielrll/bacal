package drll.problems.leetcode.rangeSumQuery2DImmutable;

public class NumMatrix {
    private final int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        sumMatrix = buildSumMatrix(matrix);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2][col2]
                - extractUpperSectionSum(row1, col2)
                - extractLeftSectionSum(col1, row2)
                + extractDiagonalSectionSum(row1, col1);
    }

    private int[][] buildSumMatrix(int[][] matrix) {
        int[][] sums = new int[matrix.length][matrix[0].length];
        for (int col = 0; col < sums[0].length; col++) {
            for (int row = 0; row < sums.length; row++) {
                sums[row][col] = matrix[row][col]
                        + extractUpperCell(row, col, sums)
                        + extractLeftCell(row, col, sums)
                        - extractDiagonalSum(row, col, sums);
            }
        }
        return sums;
    }

    private int extractDiagonalSum(int row, int col, int[][] matrix) {
        return extract(matrix, row -1, col - 1);
    }

    private int extractLeftCell(int row, int col, int[][] matrix) {
        return extract(matrix, row, col - 1);
    }

    private int extractUpperCell(int row, int col, int[][] matrix) {
        return extract(matrix, row - 1, col);
    }

    private int extractDiagonalSectionSum(int row1, int col1) {
        return extract(sumMatrix, row1 - 1, col1 - 1);
    }

    private int extractLeftSectionSum(int col1, int row2) {
        return extract(sumMatrix, row2, col1 - 1);
    }

    private int extractUpperSectionSum(int row1, int col2) {
        return extract(sumMatrix, row1 - 1, col2);
    }

    private boolean isValidCell(int row, int col, int[][] matrix) {
        return row >= 0  &&  row < matrix.length  &&
                col >= 0  &&  col < matrix[0].length;
    }

    private int extract(int[][] matrix, int row, int col) {
        return isValidCell(row, col, matrix) ? matrix[row][col] : 0;
    }
}