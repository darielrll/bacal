package drll.problems.leetcode.number_of_valid_clock_times;

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
        assertThat(solution.countTime("?5:00")).isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.countTime("0?:0?")).isEqualTo(100);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.countTime("??:??")).isEqualTo(1440);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.countTime("07:?3")).isEqualTo(6);
    }
}