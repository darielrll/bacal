package drll.problems.leetcode.RemovingStarsFromAString;

import drll.problems.leetcode.RemovingStarsFromAString.Solution;
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
        assertThat(solution.removeStars("leet**cod*e")).isEqualTo("lecoe");
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.removeStars("erase*****")).isEqualTo("");
    }
}