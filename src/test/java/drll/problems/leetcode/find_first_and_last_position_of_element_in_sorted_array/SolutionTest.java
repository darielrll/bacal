package drll.problems.leetcode.find_first_and_last_position_of_element_in_sorted_array;

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
        int[] range = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);

        assertThat(range).isEqualTo(new int[]{3, 4});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        int[] range = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);

        assertThat(range).isEqualTo(new int[]{-1, -1});
    }

    @Test
    void should_return_correctly_for_test_case3() {
        int[] range = solution.searchRange(new int[]{}, 0);

        assertThat(range).isEqualTo(new int[]{-1, -1});
    }
}