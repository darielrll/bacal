package drll.problems.leetCodeContest.LargestPalindromicNumber;

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
        assertThat(solution.largestPalindromic("444947137"))
                .isEqualTo("7449447");
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.largestPalindromic("00009"))
                .isEqualTo("9");
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.largestPalindromic("0000000000000000000000"))
                .isEqualTo("0");
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.largestPalindromic("9999"))
                .isEqualTo("9999");
    }

    @Test
    void should_return_correctly_for_test_case5() {
        assertThat(solution.largestPalindromic("99999"))
                .isEqualTo("99999");
    }
}