package drll.problems.leetcode.minimum_cost_to_set_cooking_time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumCostToSetCookingTimeTest {
    private MinimumCostToSetCookingTime problem3;

    @BeforeEach
    void init(){
        problem3 = new MinimumCostToSetCookingTime();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(problem3.minCostSetTime(1, 2, 1, 600))
                .isEqualTo(6);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(problem3.minCostSetTime(0, 1, 2, 76))
                .isEqualTo(6);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(problem3.minCostSetTime(9, 100000, 1, 6039))
                .isEqualTo(4);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(problem3.minCostSetTime(5, 15, 20, 365))
                .isEqualTo(90);
    }

    @Test
    void should_return_correctly_for_test_case5() {
        assertThat(problem3.minCostSetTime(1, 583, 18, 64))
                .isEqualTo(1202);
    }

    @Test
    void should_return_correctly_for_test_case6() {
        assertThat(problem3.minCostSetTime(5, 3269, 3270, 650))
                .isEqualTo(26156);
    }

    @Test
    void should_return_correctly_for_test_case7() {
        assertThat(problem3.minCostSetTime(0, 1, 4, 9))
                .isEqualTo(5);
    }
}