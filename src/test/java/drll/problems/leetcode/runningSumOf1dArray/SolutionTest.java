package drll.problems.leetcode.runningSumOf1dArray;

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
        assertThat(solution.runningSum(new int[]{1, 2, 3, 4})).isEqualTo(new int[]{1, 3, 6, 10});
    }

    @Test
    public void should_return_correctly_for_test_case2() {
        assertThat(solution.runningSum(new int[]{1, 1, 1, 1, 1})).isEqualTo(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void should_return_correctly_for_test_case3() {
        assertThat(solution.runningSum(new int[]{3, 1, 2, 10, 1})).isEqualTo(new int[]{3, 4, 6, 16, 17});
    }
}