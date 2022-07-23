package drll.problems.leetcode.calculateAmountPaidInTaxes;

import drll.problems.leetcode.calculateAmountPaidInTaxes.Solution;
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
        assertThat(solution.calculateTax(
                new int[][]{
                        {3, 50},
                        {7, 10},
                        {12, 25}
                }, 10
        )).isEqualTo(2.65000);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.calculateTax(
                new int[][]{
                        {1, 0},
                        {4, 25},
                        {5, 50}
                }, 2
        )).isEqualTo(0.25000);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.calculateTax(
                new int[][]{
                        {2, 50}
                }, 0
        )).isEqualTo(0.00000);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.calculateTax(
                new int[][]{
                        {4, 8},
                        {5, 49}
                }, 2
        )).isEqualTo(0.16000);
    }
}