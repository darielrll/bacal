package drll.problems.leetcode.longest_substring_without_repeating_characters;

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
        assertThat(solution.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.lengthOfLongestSubstring(" ")).isEqualTo(1);
    }
}