package drll.problems.leetcode.squaresOfASortedArray;

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
        assertThat(solution.sortedSquares(new int[]{-4, -1, 0, 3, 10}))
                .isEqualTo(new int[]{0, 1, 9, 16, 100});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.sortedSquares(new int[]{-7, -3, 2, 3, 11}))
                .isEqualTo(new int[]{4, 9, 9, 49, 121});
    }
}