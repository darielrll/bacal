package drll.problems.leetcodeContest.CountLatticePointsInsideACircle;

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
        assertThat(solution.countLatticePoints(new int[][]{
                {2,2,1}
        })).isEqualTo(5);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.countLatticePoints(new int[][]{
                {2,2,2}, {3,4,1}
        })).isEqualTo(16);
    }
}