package drll.problems.leetcode.find_peak_element;

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
        Integer countDifferentDigits = solution.findPeakElement(new int[]{1, 2, 3, 1});

        assertThat(countDifferentDigits).isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        Integer countDifferentDigits = solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});

        assertThat(countDifferentDigits).isEqualTo(5);
    }
}