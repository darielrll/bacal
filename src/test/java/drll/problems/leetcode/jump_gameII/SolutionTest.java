package drll.problems.leetcode.jump_gameII;

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
        assertThat(solution.jump(new int[]{0})).isEqualTo(0);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.jump(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.jump(new int[]{2, 3, 0, 1, 4})).isEqualTo(2);
    }
}