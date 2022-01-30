package drll.problems.leetcode.TwoSumIIInputArrayIsSorted;

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
        assertThat(solution.twoSum(new int[]{2, 7, 11, 15}, 9))
                .isEqualTo(new int[]{1, 2});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.twoSum(new int[]{2, 3, 4}, 6))
                .isEqualTo(new int[]{1, 3});
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.twoSum(new int[]{-1, 0}, -1))
                .isEqualTo(new int[]{1, 2});
    }

    @Test
    void should_return_correctly_for_test_case5() {
        assertThat(solution.twoSum(new int[]{0, 0, 3, 4}, 0))
                .isEqualTo(new int[]{1, 2});
    }

    @Test
    void should_return_correctly_for_test_case6() {
        assertThat(solution.twoSum(new int[]{5, 25, 75}, 100))
                .isEqualTo(new int[]{2, 3});
    }
}