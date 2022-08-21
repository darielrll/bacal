package drll.problems.leetCodeContest.problem1;

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
        assertThat(solution.minimumRecolors("WBBWWBBWBW", 7)).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.minimumRecolors("WBWBBBW", 2)).isEqualTo(0);
    }
}