package drll.problems.leetcode.EqualRowAndColumnPairs;

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
        assertThat(solution.equalPairs(
                new int[][]{
                        {3,2,1},
                        {1,7,6},
                        {2,7,7}
                }
        )).isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.equalPairs(
                new int[][]{
                        {3,1,2,2},
                        {1,4,4,5},
                        {2,4,2,2},
                        {2,4,2,2}
                }
        )).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.equalPairs(
                new int[][]{
                        {3,3,3,6,18,3,3,3,3,3},
                        {3,3,3,3,1,3,3,3,3,3},
                        {3,3,3,3,1,3,3,3,3,3},
                        {3,3,3,3,1,3,3,3,3,3},
                        {1,1,1,11,19,1,1,1,1,1},
                        {3,3,3,18,19,3,3,3,3,3},
                        {3,3,3,3,1,3,3,3,3,3},
                        {3,3,3,3,1,3,3,3,3,3},
                        {3,3,3,1,6,3,3,3,3,3},
                        {3,3,3,3,1,3,3,3,3,3}
                }
        )).isEqualTo(48);
    }
}