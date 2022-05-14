package drll.problems.leetcode.FindTheKBeautyOfANumber;

import drll.problems.leetcode.FindTheKBeautyOfANumber.Solution;
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
        assertThat(solution.divisorSubstrings( 240, 2)).isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.divisorSubstrings( 430043, 2)).isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.divisorSubstrings( 2, 1)).isEqualTo(1);
    }
}