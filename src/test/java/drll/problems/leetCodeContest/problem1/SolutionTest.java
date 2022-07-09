package drll.problems.leetcodeContest.problem1;

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
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        String expected = "this is a secret";

        assertThat(solution.decodeMessage(key, message))
                .isEqualTo(expected);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        String expected = "the five boxing wizards jump quickly";

        assertThat(solution.decodeMessage(key, message))
                .isEqualTo(expected);
    }
}