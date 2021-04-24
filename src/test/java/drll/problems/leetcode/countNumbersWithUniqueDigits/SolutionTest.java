package drll.problems.leetcode.countNumbersWithUniqueDigits;

import drll.problems.leetcode.countNumbersWithUniqueDigits.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void init(){
        solution = new Solution();
    }

    @Test
    public void should_return_correctly_for_test_case1() {
        Integer countDifferentsDigits = solution.countNumbersWithUniqueDigits(2);

        assertThat(countDifferentsDigits).isEqualTo(91);
    }

    @Test
    public void should_return_correctly_for_test_case2() {
        Integer countDifferentsDigits = solution.countNumbersWithUniqueDigits(0);

        assertThat(countDifferentsDigits).isEqualTo(1);
    }
}