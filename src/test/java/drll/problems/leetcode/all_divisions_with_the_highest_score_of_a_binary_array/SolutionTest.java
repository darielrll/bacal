package drll.problems.leetcode.all_divisions_with_the_highest_score_of_a_binary_array;

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
        List<Integer> highestDivisionScore = solution.maxScoreIndices(new int[]{0, 0, 1, 0});

        assertThat(highestDivisionScore.size()).isEqualTo(2);
        assertThat(highestDivisionScore.get(0)).isEqualTo(2);
        assertThat(highestDivisionScore.get(1)).isEqualTo(4);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        List<Integer> highestDivisionScore = solution.maxScoreIndices(new int[]{0, 0, 0});

        assertThat(highestDivisionScore.size()).isEqualTo(1);
        assertThat(highestDivisionScore.get(0)).isEqualTo(3);
    }
}