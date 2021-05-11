package drll.problems.leetcode.countPrimes;

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
        assertThat(solution.countPrimes(10)).isEqualTo(4);
    }

    @Test
    public void should_return_correctly_for_test_case2() {
        assertThat(solution.countPrimes(0)).isEqualTo(0);
    }

    @Test
    public void should_return_correctly_for_test_case3() {
        assertThat(solution.countPrimes(2)).isEqualTo(0);
    }

    @Test
    public void should_return_correctly_for_test_case4() {
        assertThat(solution.countPrimes(1)).isEqualTo(0);
    }

    @Test
    public void should_return_correctly_for_test_case5() {
        assertThat(solution.countPrimes(5000000)).isEqualTo(348513);
    }
}