package drll.problems.leetCodeContest.problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(solution.search(new int[]{3,2,3,2,2,2})).isTrue();
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.search(new int[]{1,2,3,4})).isFalse();
    }
}