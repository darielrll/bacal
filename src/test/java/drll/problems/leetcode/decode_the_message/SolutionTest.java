package drll.problems.leetcode.decode_the_message;

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
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";

        assertThat(solution.decodeMessage(key, message)).isEqualTo("this is a secret");
    }

    @Test
    void should_return_correctly_for_test_case2() {
        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";

        assertThat(solution.decodeMessage(key, message)).isEqualTo("the five boxing wizards jump quickly");
    }
}