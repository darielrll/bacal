package drll.problems.leetcode.sorting_the_sentence;

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
        assertThat(solution.sortSentence("is2 sentence4 This1 a3"))
                .isEqualTo("This is a sentence");
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.sortSentence("Myself2 Me1 I4 and3"))
                .isEqualTo("Me Myself and I");
    }
}