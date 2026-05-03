package drll.problems.leetcode.rotate_string;

import drll.problems.leetcode.rotate_string.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertTrue(solution.rotateString("abcde", "cdeab"));
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertFalse(solution.rotateString("abcde", "abced"));
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertFalse(solution.rotateString("aa", "a"));
    }

}