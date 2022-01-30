package drll.problems.leetcode.KeepMultiplyingFoundValuesByTwo;

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
        assertThat(solution.findFinalValue(new int[]{5, 3, 6, 1, 12}, 3))
                .isEqualTo(24);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.findFinalValue(new int[]{2, 7, 9}, 4))
                .isEqualTo(4);
    }
}