package drll.problems.leetcodeContest.problem3;

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
        assertThat(solution.peopleAwareOfSecret(6, 2, 4)).isEqualTo(5);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.peopleAwareOfSecret(4, 1, 3)).isEqualTo(6);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.peopleAwareOfSecret(4, 1, 4)).isEqualTo(8);
    }
}