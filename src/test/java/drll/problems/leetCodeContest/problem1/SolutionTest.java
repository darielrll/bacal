package drll.problems.leetCodeContest.problem1;

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
        assertThat(solution.countDaysTogether(
                "08-15","08-18",
                "08-16", "08-19"))
                .isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.countDaysTogether(
                "10-01", "10-31",
                "11-01", "12-31"))
                .isZero();
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.countDaysTogether(
                "09-01", "10-19",
                "06-19", "10-20"))
                .isEqualTo(49);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.countDaysTogether(
                "08-06", "12-08",
                "02-04", "09-01"))
                .isEqualTo(27);
    }

    @Test
    void should_return_correctly_for_test_case5() {
        assertThat(solution.countDaysTogether(
                "01-15", "11-12",
                "01-15", "02-03"))
                .isEqualTo(20);
    }
}