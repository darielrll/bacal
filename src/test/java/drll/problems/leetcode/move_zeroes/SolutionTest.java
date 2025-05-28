package drll.problems.leetcode.move_zeroes;

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
        int[] nums = {0, 1, 0, 3, 12};

        solution.moveZeroes(nums);

        assertThat(nums).isEqualTo(new int[] {1, 3, 12, 0, 0});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        int[] nums = {0};

        solution.moveZeroes(nums);

        assertThat(nums).isEqualTo(new int[] {0});
    }
}