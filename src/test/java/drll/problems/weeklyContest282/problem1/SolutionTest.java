package drll.problems.weeklyContest282.problem1;

import drll.problems.weeklyContest282.CountingWordsWithAGivenPrefix.Solution;
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
        assertThat(solution.prefixCount(new String[]{"pay","attention","practice","attend"}, "at"))
                .isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.prefixCount(new String[]{"leetcode","win","loops","success"}, "code"))
                .isZero();
    }
}