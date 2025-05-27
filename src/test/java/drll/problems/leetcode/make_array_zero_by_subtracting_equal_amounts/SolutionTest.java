package drll.problems.leetcode.make_array_zero_by_subtracting_equal_amounts;

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
        assertThat(solution.minimumOperations(new int[]{1,5,0,3,5})).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.minimumOperations(new int[]{0})).isEqualTo(0);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.minimumOperations(new int[]{1})).isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.minimumOperations(new int[]{0,0,0,0})).isEqualTo(0);
    }
}