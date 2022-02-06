package drll.problems.leetcode.minimumSumOfFourDigitNumberAfterSplittingDigits;

import drll.problems.leetcode.minimumSumOfFourDigitNumberAfterSplittingDigits.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumSumOfFourDigitNumberAfterSplittingDigitsTest {
    private Solution problem1;

    @BeforeEach
    void init(){
        problem1 = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(problem1.minimumSum(2932)).isEqualTo(52);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(problem1.minimumSum(4009)).isEqualTo(13);
    }
}