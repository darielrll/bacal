package drll.problems.leetcode.DivideIntervalsIntoMinimumNumberOfGroups;

import drll.problems.leetcode.DivideIntervalsIntoMinimumNumberOfGroups.Solution;
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
        assertThat(solution.minGroups( new int[][]{
                {5,10},{6,8},{1,5},{2,3},{1,10}
        })).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.minGroups( new int[][]{
                {1,3},{5,6},{8,10},{11,13}
        })).isEqualTo(1);
    }
}