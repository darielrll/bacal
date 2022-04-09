package drll.problems.leetcode.FindTheDifferenceOfTwoArrays;

import drll.problems.leetcode.FindTheDifferenceOfTwoArrays.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(solution.findDifference(new int[]{1,2,3}, new int[]{2,4,6}))
            .isEqualTo(Arrays.asList(Arrays.asList(1,3), Arrays.asList(4, 6)));
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}))
            .isEqualTo(Arrays.asList(Arrays.asList(3), Arrays.asList()));
    }
}