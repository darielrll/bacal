package drll.problems.leetcode.MinimumNumberOfStepsToMakeTwoStringsAnagramII;

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
        assertThat(solution.minSteps("leetcode", "coats")).isEqualTo(7);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.minSteps("night","thing")).isZero();
    }
}