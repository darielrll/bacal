package drll.problems.leetCodeContest.MinimumHoursOfTrainingToWinACompetition;

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
        assertThat(solution.minNumberOfHours(5, 3,
                new int[]{1,4,3,2}, new int[]{2,6,3,1})).isEqualTo(8);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.minNumberOfHours(2, 4,
                new int[]{1}, new int[]{3})).isEqualTo(0);
    }
}