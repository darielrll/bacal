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
        assertThat(solution.mostFrequentEven( new int[] {0,1,2,2,4,4,1})).isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.mostFrequentEven( new int[] {4,4,4,9,2,4})).isEqualTo(4);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.mostFrequentEven( new int[] {29,47,21,41,13,37,25,7})).isEqualTo(-1);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.mostFrequentEven( new int[] {2,2,4,4})).isEqualTo(2);
    }
}