package drll.problems.leetcode.FindSubarraysWithEqualSum;

import drll.problems.leetcode.FindSubarraysWithEqualSum.Solution;
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
        assertThat(solution.findSubarrays(new int[]{4,2,4})).isTrue();
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.findSubarrays(new int[]{0,0,0})).isTrue();
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.findSubarrays(new int[]{1,2,3,4,5})).isFalse();
    }
}