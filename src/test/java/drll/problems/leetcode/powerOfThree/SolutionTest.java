package drll.problems.leetcode.powerOfThree;

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
        assertThat(solution.isPowerOfThree(27)).isTrue();
    }

    @Test
    public void should_return_correctly_for_test_case2() {
        assertThat(solution.isPowerOfThree(0)).isFalse();
    }

    @Test
    public void should_return_correctly_for_test_case3() {
        assertThat(solution.isPowerOfThree(9)).isTrue();
    }

    @Test
    public void should_return_correctly_for_test_case4() {
        assertThat(solution.isPowerOfThree(45)).isFalse();
    }

    @Test
    public void should_return_correctly_for_test_case5() {
        assertThat(solution.isPowerOfThree(19682)).isFalse();
    }

    @Test
    public void should_return_correctly_for_test_case6() {
        assertThat(solution.isPowerOfThree(19683)).isTrue();
    }

    @Test
    public void should_return_correctly_for_test_case7() {
        assertThat(solution.isPowerOfThree(243)).isTrue();
    }

    @Test
    public void should_return_correctly_for_test_case8() {
        assertThat(solution.isPowerOfThree(1)).isTrue();
    }

    @Test
    public void should_return_correctly_for_test_case9() {
        assertThat(solution.isPowerOfThree(-9)).isFalse();
    }
}