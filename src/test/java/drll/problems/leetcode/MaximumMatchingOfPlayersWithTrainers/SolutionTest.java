package drll.problems.leetcode.MaximumMatchingOfPlayersWithTrainers;

import drll.problems.leetcode.MaximumMatchingOfPlayersWithTrainers.Solution;
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
        assertThat(solution.matchPlayersAndTrainers(
                new int[]{4,7,9},
                new int[]{8,2,5,8}
        )).isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.matchPlayersAndTrainers(
                new int[]{1,1,1},
                new int[]{10}
        )).isOne();
    }
}