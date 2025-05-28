package drll.problems.leetcode.smallest_value_of_the_rearranged_number;

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
        assertThat(solution.smallestNumber(310)).isEqualTo(103);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.smallestNumber(-7605)).isEqualTo(-7650);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.smallestNumber(-2230363001l)).isEqualTo(-6333221000L);
    }
}