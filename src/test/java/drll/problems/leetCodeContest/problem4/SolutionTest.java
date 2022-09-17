package drll.problems.leetCodeContest.problem4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(solution.lengthOfLIS( new int[]{4,2,1,4,3,4,5,8,15}, 3)).isEqualTo(5);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.lengthOfLIS( new int[]{7,4,5,1,8,12,4,7}, 5)).isEqualTo(4);
    }
}