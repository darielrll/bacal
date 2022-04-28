package drll.problems.pendingSolution.FindPalindromeWithFixedLength;

import drll.problems.pendingSolution.FindPalindromeWithFixedLength.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    @Disabled
    void should_return_correctly_for_test_case1() {
        assertThat(solution.kthPalindrome(new int[]{1,2,3,4,5,90}, 3))
                .isEqualTo(new long[]{101,111,121,131,141,999});
    }
    @Test
    @Disabled
    void should_return_correctly_for_test_case2() {
        assertThat(solution.kthPalindrome(new int[]{2,4,6}, 4))
                .isEqualTo(new long[]{1111,1331,1551});
    }
}