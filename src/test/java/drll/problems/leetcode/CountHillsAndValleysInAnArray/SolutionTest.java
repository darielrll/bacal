package drll.problems.leetcode.CountHillsAndValleysInAnArray;

import drll.problems.leetcode.CountHillsAndValleysInAnArray.Solution;
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
        assertThat(solution.countHillValley(new int[]{2,4,1,1,6,5})).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.countHillValley(new int[]{6,6,5,5,4,1})).isEqualTo(0);
    }
}