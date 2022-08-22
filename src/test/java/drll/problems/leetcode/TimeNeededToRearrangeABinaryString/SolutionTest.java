package drll.problems.leetcode.TimeNeededToRearrangeABinaryString;

import drll.problems.leetcode.TimeNeededToRearrangeABinaryString.Solution;
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
        assertThat(solution.secondsToRemoveOccurrences("0110101")).isEqualTo(4);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.secondsToRemoveOccurrences("11100")).isEqualTo(0);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.secondsToRemoveOccurrences("001011")).isEqualTo(4);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.secondsToRemoveOccurrences("1011010101")).isEqualTo(5);
    }

    @Test
    void should_return_correctly_for_test_case5() {
        assertThat(solution.secondsToRemoveOccurrences("01011110")).isEqualTo(5);
    }

    @Test
    void should_return_correctly_for_test_case6() {
        assertThat(solution.secondsToRemoveOccurrences("10101")).isEqualTo(2);
    }
}