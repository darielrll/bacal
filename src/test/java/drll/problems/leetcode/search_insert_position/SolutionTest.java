package drll.problems.leetcode.search_insert_position;

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
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 5)).isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 2)).isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 7)).isEqualTo(4);
    }
}