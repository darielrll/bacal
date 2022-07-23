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
        assertThat(solution.bestHand(new int[]{13,2,3,1,9}, new char[]{'a','a','a','a','a'}))
                .isEqualTo("Flush");
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.bestHand(new int[]{4,4,2,4,4}, new char[]{'d','a','a','b','c'}))
                .isEqualTo("Three of a Kind");
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.bestHand(new int[]{10,10,2,12,9}, new char[]{'a','b','c','a','d'}))
                .isEqualTo("Pair");
    }
}