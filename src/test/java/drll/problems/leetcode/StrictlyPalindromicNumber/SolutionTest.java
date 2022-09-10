package drll.problems.leetcode.StrictlyPalindromicNumber;

import drll.problems.leetcode.StrictlyPalindromicNumber.Solution;
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
        assertThat(solution.isStrictlyPalindromic(9)).isFalse();
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.isStrictlyPalindromic(4)).isFalse();
    }
}