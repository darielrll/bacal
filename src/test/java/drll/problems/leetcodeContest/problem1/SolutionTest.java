package drll.problems.leetcodeContest.problem1;

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
        assertThat(solution.mostFrequent(new int[]{1,100,200,1,100}, 1)).isEqualTo(100);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.mostFrequent(new int[]{2,2,2,2,3}, 2)).isEqualTo(2);
    }
}