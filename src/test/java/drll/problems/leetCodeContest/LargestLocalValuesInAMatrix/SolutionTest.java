package drll.problems.leetCodeContest.LargestLocalValuesInAMatrix;

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
        assertThat(solution.largestLocal(new int[][]{
                {9,9,8,1},
                {5,6,2,6},
                {8,2,6,4},
                {6,2,2,2}
        })).isEqualTo(new int[][]{
                {9,9},
                {8,6}
        });
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.largestLocal(new int[][]{
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,2,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1}
        })).isEqualTo(new int[][]{
                {2,2,2},
                {2,2,2},
                {2,2,2}
        });
    }
}