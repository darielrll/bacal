package drll.problems.hacker_rank.coin_change_problem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.assertj.core.api.Assertions.*;

class CoinChangeProblemTest {

    @Test
    void should_get_correct_answer_for_test_case_1() {

        long ways = CoinChangeProblem.getWays(4, new long[]{1, 2, 3});

        assertThat(ways).isEqualTo(4);
    }

    @Test
    void should_get_correct_answer_for_test_case_2() {

        long ways = CoinChangeProblem.getWays(10, new long[]{2, 5, 3, 6});

        assertThat(ways).isEqualTo(5);
    }

    @Test()
    @Timeout(value = 1)
    void should_get_correct_answer_for_test_case_3() {

        long ways = CoinChangeProblem.getWays(166, new long[]{
                5, 37, 8, 39, 33, 17, 22,
                32, 13, 7, 10, 35, 40, 2,
                43, 49, 46, 19, 41, 1, 12,
                11, 28});

        assertThat(ways).isEqualTo(96190959);
    }

    @Test()
    @Timeout(value = 1)
    void should_get_correct_answer_for_test_case_4() {

        long ways = CoinChangeProblem.getWays(219, new long[]{
                36, 10, 42, 7, 50, 1, 49,
                24, 37, 12, 34, 13, 39,
                18, 8, 29, 19, 43, 5, 44,
                28, 23, 35, 26});

        assertThat(ways).isEqualTo(168312708);
    }
}