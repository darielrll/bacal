package drll.problems.leetcode.NodeWithHighestEdgeScore;

import common.Utils;
import drll.problems.leetcode.NodeWithHighestEdgeScore.Solution;
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
        assertThat(solution.edgeScore(new int[]{1,0,0,0,0,7,7,5})).isEqualTo(7);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.edgeScore(new int[]{2,0,0,2})).isZero();
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.edgeScore(new int[]{1,0,1,1,1,1,1,1})).isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.edgeScore(Utils.buildArrayIntFromFile("NodeWithHighestEdgeScore/testCase1.txt", ","))).isEqualTo(1);
    }
}