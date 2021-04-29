package drll.problems.leetcode.findFirstAndLastPositionOfElementInSortedArray;

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
        int[] range = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);

        assertThat(range).isEqualTo(new int[]{3, 4});
    }

    @Test
    public void should_return_correctly_for_test_case2() {
        int[] range = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);

        assertThat(range).isEqualTo(new int[]{-1, -1});
    }

    @Test
    public void should_return_correctly_for_test_case3() {
        int[] range = solution.searchRange(new int[]{}, 0);

        assertThat(range).isEqualTo(new int[]{-1, -1});
    }
}