package drll.problems.leetCodeContest.problem3;

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
        assertThat(solution.garbageCollection(
                new String[]{"G","P","GP","GG"},
                new int[]{2,4,3}))
                .isEqualTo(21);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.garbageCollection(
                new String[]{"MMM","PGM","GP"},
                new int[]{3, 10}))
                .isEqualTo(37);
    }
}