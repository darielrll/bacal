package drll.problems.leetcode.superPalindromes;

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
    void should_return_correctly_for_test_case1() {
        assertThat(solution.superpalindromesInRange("4", "1000")).isEqualTo(4);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.superpalindromesInRange("1", "2")).isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.superpalindromesInRange("40000000000000000", "50000000000000000")).isEqualTo(2);
    }
}