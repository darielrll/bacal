package drll.problems.leetcode.CountArtifactsThatCanBeExtracted;

import drll.problems.leetcode.CountArtifactsThatCanBeExtracted.Solution;
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
        int n = 2;
        int[][] artifacts = new int[][]{
                {0,0,0,0},
                {0,1,1,1}
        };
        int[][] dig = new int[][]{
                {0,0},
                {0,1}
        };

        assertThat(solution.digArtifacts(n, artifacts, dig)).isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        int n = 2;
        int[][] artifacts = new int[][]{
                {0,0,0,0},
                {0,1,1,1}
        };
        int[][] dig = new int[][]{
                {0,0},
                {0,1},
                {1,1}
        };

        assertThat(solution.digArtifacts(n, artifacts, dig)).isEqualTo(2);
    }
}