package drll.problems.leetCodeContest.problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(solution.triangularSum(new int[]{1,2,3,4,5})).isEqualTo(8);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.triangularSum(new int[]{5})).isEqualTo(5);
    }
}