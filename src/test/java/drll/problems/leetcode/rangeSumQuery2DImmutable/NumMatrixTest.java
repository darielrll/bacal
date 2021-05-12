package drll.problems.leetcode.rangeSumQuery2DImmutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumMatrixTest {
    private NumMatrix numMatrix;
    int[][] matrix = getTestCaseMatrix1();

    @BeforeEach
    public void init(){
        matrix = getTestCaseMatrix1();
    }

    @Test
    public void should_return_correctly_for_test_case1() {
        numMatrix = new NumMatrix(matrix);

        assertThat(numMatrix.sumRegion(2, 1, 4, 3)).isEqualTo(8);
    }

    @Test
    public void should_return_correctly_for_test_case2() {
        numMatrix = new NumMatrix(matrix);

        assertThat(numMatrix.sumRegion(1, 1, 2, 2)).isEqualTo(11);
    }

    @Test
    public void should_return_correctly_for_test_case3() {
        numMatrix = new NumMatrix(matrix);

        assertThat(numMatrix.sumRegion(1, 2, 2, 4)).isEqualTo(12);
    }

    @Test
    public void should_return_correctly_for_test_case4() {
        numMatrix = new NumMatrix(getTestCaseMatrix2());

        assertThat(numMatrix.sumRegion(0,0,0,0)).isEqualTo(-4);
    }

    @Test
    public void should_return_correctly_for_test_case5() {
        numMatrix = new NumMatrix(getTestCaseMatrix2());

        assertThat(numMatrix.sumRegion(0,0,0,1)).isEqualTo(-9);
    }

    @Test
    public void should_return_correctly_for_test_case6() {
        numMatrix = new NumMatrix(getTestCaseMatrix2());

        assertThat(numMatrix.sumRegion(0,1,0,1)).isEqualTo(-5);
    }

    private int[][] getTestCaseMatrix1() {
        return new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
    }

    private int[][] getTestCaseMatrix2() {
        return new int[][]{
                {-4, -5}
        };
    }
}