package drll.problems.leetcode.incremental_memory_leak;

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
        assertThat(solution.memLeak(2, 2))
                .isEqualTo(new int[]{3, 1, 0});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.memLeak(8, 11))
                .isEqualTo(new int[]{6, 0, 4});
    }
}