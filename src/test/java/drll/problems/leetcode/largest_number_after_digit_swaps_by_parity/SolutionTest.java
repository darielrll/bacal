package drll.problems.leetcode.largest_number_after_digit_swaps_by_parity;

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
        assertThat(solution.largestInteger(1234)).isEqualTo(3412);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.largestInteger(65875)).isEqualTo(87655);
    }
}