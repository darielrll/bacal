package drll.problems.leetcode.countNumbersWithUniqueDigits;

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
        Integer countDifferentsDigits = solution.countNumbersWithUniqueDigits(2);

        assertThat(countDifferentsDigits).isEqualTo(91);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        Integer countDifferentsDigits = solution.countNumbersWithUniqueDigits(0);

        assertThat(countDifferentsDigits).isEqualTo(1);
    }
}