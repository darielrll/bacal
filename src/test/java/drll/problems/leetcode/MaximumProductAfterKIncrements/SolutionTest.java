package drll.problems.leetcode.MaximumProductAfterKIncrements;

import drll.problems.leetcode.MaximumProductAfterKIncrements.Solution;
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
        assertThat(solution.maximumProduct(new int[]{0,4}, 5)).isEqualTo(20);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.maximumProduct(new int[]{6,3,3,2}, 2)).isEqualTo(216);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.maximumProduct(new int[]{9,7,8}, 9)).isEqualTo(1331);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.maximumProduct(new int[]{24,5,64,53,26,38}, 54)).isEqualTo(180820950);
    }
}