package drll.problems.leetcode.reverse_string;

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
        char[] word = {'h', 'e', 'l', 'l', 'o'};

        solution.reverseString(word);

        assertThat(word).isEqualTo(new char[]{'o','l','l','e','h'});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        char[] word = {'H','a','n','n','a','h'};

        solution.reverseString(word);

        assertThat(word).isEqualTo(new char[]{'h','a','n','n','a','H'});
    }
}