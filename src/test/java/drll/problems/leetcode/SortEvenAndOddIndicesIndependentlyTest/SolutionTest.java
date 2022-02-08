package drll.problems.leetcode.SortEvenAndOddIndicesIndependentlyTest;

import drll.problems.leetcode.SortEvenAndOddIndicesIndependently.Solution;
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
        assertThat(solution.sortEvenOdd(new int[]{4,1,2,3})).
                isEqualTo(new int[]{2,3,4,1});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.sortEvenOdd(new int[]{2,1})).
                isEqualTo(new int[]{2,1});
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.sortEvenOdd(new int[]{2})).
                isEqualTo(new int[]{2});
    }
}