package drll.problems.leetcode.CountOperationsToObtainZero;

import drll.problems.leetcode.CountOperationsToObtainZero.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution problem1;

    @BeforeEach
    void init(){
        problem1 = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(problem1.countOperations(2, 3)).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(problem1.countOperations(10, 10)).isEqualTo(1);
    }
}