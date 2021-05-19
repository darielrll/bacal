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
        Integer countDifferentDigits = solution.countNumbersWithUniqueDigits(2);

        assertThat(countDifferentDigits).isEqualTo(91);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        Integer countDifferentDigits = solution.countNumbersWithUniqueDigits(0);

        assertThat(countDifferentDigits).isEqualTo(1);
    }
}