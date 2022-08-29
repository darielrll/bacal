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
        assertThat(solution.answerQueries(new int[]{4,5,2,1}, new int[]{3,10,21}))
                .isEqualTo(new int[]{2,3,4});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.answerQueries(new int[]{2,3,4,5}, new int[]{1}))
                .isEqualTo(new int[]{0});
    }
}