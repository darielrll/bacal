package drll.problems.leetcode.findPeakElement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void init(){
        solution = new Solution();
    }

    @Test
    public void should_return_correctly_for_test_case1() {
        Integer countDifferentsDigits = solution.findPeakElement(new int[]{1, 2, 3, 1});

        assertThat(countDifferentsDigits).isEqualTo(2);
    }

    @Test
    public void should_return_correctly_for_test_case2() {
        Integer countDifferentsDigits = solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});

        assertThat(countDifferentsDigits).isEqualTo(5);
    }
}