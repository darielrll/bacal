package drll.problems.leetcode.powerfulIntegers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        List<Integer> countDifferentDigits = solution.powerfulIntegers(2, 3, 10);

        assertThat(countDifferentDigits.size()).isEqualTo(7);
        assertThat(countDifferentDigits.contains(2)).isTrue();
        assertThat(countDifferentDigits.contains(3)).isTrue();
        assertThat(countDifferentDigits.contains(4)).isTrue();
        assertThat(countDifferentDigits.contains(5)).isTrue();
        assertThat(countDifferentDigits.contains(7)).isTrue();
        assertThat(countDifferentDigits.contains(9)).isTrue();
        assertThat(countDifferentDigits.contains(10)).isTrue();
    }

    @Test
    void should_return_correctly_for_test_case2() {
        List<Integer> countDifferentDigits = solution.powerfulIntegers(3, 5, 15);

        assertThat(countDifferentDigits.size()).isEqualTo(6);
        assertThat(countDifferentDigits.contains(2)).isTrue();
        assertThat(countDifferentDigits.contains(4)).isTrue();
        assertThat(countDifferentDigits.contains(6)).isTrue();
        assertThat(countDifferentDigits.contains(8)).isTrue();
        assertThat(countDifferentDigits.contains(10)).isTrue();
        assertThat(countDifferentDigits.contains(14)).isTrue();
    }

    @Test
    void should_return_correctly_for_test_case3() {
        List<Integer> countDifferentDigits = solution.powerfulIntegers(2, 1, 10);

        assertThat(countDifferentDigits.size()).isEqualTo(4);
        assertThat(countDifferentDigits.contains(2)).isTrue();
        assertThat(countDifferentDigits.contains(3)).isTrue();
        assertThat(countDifferentDigits.contains(5)).isTrue();
        assertThat(countDifferentDigits.contains(9)).isTrue();
    }
}