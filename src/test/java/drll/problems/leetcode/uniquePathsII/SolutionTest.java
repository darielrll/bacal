package drll.problems.leetcode.uniquePathsII;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        int[][] grid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        assertThat(solution.uniquePathsWithObstacles(grid)).isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        int[][] grid = new int[][]{
                {0, 1},
                {0, 0   }
        };

        assertThat(solution.uniquePathsWithObstacles(grid)).isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        int[][] grid = new int[][]{
                {0}
        };

        assertThat(solution.uniquePathsWithObstacles(grid)).isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        int[][] grid = new int[][]{
                {1}
        };

        assertThat(solution.uniquePathsWithObstacles(grid)).isEqualTo(0);
    }

    @Test
    void should_return_correctly_for_test_case5() {
        int[][] grid = new int[][]{
                {0, 0}
        };

        assertThat(solution.uniquePathsWithObstacles(grid)).isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case6() {
        int[][] grid = new int[][]{
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        assertThat(solution.uniquePathsWithObstacles(grid)).isEqualTo(1);
    }
}