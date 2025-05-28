package drll.problems.leetcode.strong_password_checkerII;

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
        assertThat(solution.strongPasswordCheckerII("IloveLe3tcode!")).isTrue();
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.strongPasswordCheckerII("Me+You--IsMyDream")).isFalse();
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.strongPasswordCheckerII("1aB!")).isFalse();
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.strongPasswordCheckerII("ziyS5FrPQhoQ5oEWRpHW2MjI7sGfcMJdcsjQnIyRbdCilvFaQN07jQtAkOklbjFrU5KcHzw4EvJ41Yz2Ykyd"))
                .isFalse();
    }
}