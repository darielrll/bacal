package drll.problems.leetcode.check_if_number_has_equal_digit_count_and_digit_value;

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
        assertThat(solution.digitCount("1210")).isTrue();
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.digitCount("030")).isFalse();
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.digitCount("1")).isFalse();
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.digitCount("89")).isFalse();
    }
}