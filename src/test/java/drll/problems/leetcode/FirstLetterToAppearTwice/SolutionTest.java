package drll.problems.leetcode.FirstLetterToAppearTwice;

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
        assertThat(solution.repeatedCharacter("abccbaacz")).isEqualTo('c');
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.repeatedCharacter("abcdd")).isEqualTo('d');
    }
}