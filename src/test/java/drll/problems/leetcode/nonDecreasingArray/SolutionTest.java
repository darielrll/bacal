package drll.problems.leetcode.nonDecreasingArray;

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
        assertThat(solution.checkPossibility(new int[]{1, 2, 3, 1})).isTrue();
    }

    @Test
    public void should_return_correctly_for_test_case2() {
        assertThat(solution.checkPossibility(new int[]{4, 2, 1})).isFalse();
    }

    @Test
    public void should_return_correctly_for_test_case3() {
        assertThat(solution.checkPossibility(new int[]{4, 2, 3})).isTrue();
    }

    @Test
    public void should_return_correctly_for_test_case4() {
        assertThat(solution.checkPossibility(new int[]{-1, 4, 2, 3})).isTrue();
    }

    @Test
    public void should_return_correctly_for_test_case5() {
        assertThat(solution.checkPossibility(new int[]{3, 4, 2, 3})).isFalse();
    }

    @Test
    public void should_return_correctly_for_test_case6() {
        assertThat(solution.checkPossibility(new int[]{2, 3, 3, 2, 2})).isFalse();
    }

    @Test
    public void should_return_correctly_for_test_case7() {
        assertThat(solution.checkPossibility(new int[]{5, 7, 1, 8})).isTrue();
    }

    @Test
    public void should_return_correctly_for_test_case8() {
        assertThat(solution.checkPossibility(new int[]{1})).isTrue();
    }

    @Test
    public void should_return_correctly_for_test_case9() {
        assertThat(solution.checkPossibility(new int[]{2, 4, 1, 3, 5})).isFalse();
    }

    @Test
    public void should_return_correctly_for_test_case10() {
        assertThat(solution.checkPossibility(new int[]{1, 5, 4, 6, 7, 8, 9})).isTrue();
    }

    @Test
    public void should_return_correctly_for_test_case11() {
        assertThat(solution.checkPossibility(new int[]{2, 3, 1, 4, 5})).isTrue();
    }

    @Test
    public void should_return_correctly_for_test_case12() {
        assertThat(solution.checkPossibility(new int[]{1, 2, 3})).isTrue();
    }
}