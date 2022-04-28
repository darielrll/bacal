package drll.problems.leetcode.IntersectionOfMultipleArrays;

import drll.problems.leetcode.IntersectionOfMultipleArrays.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(solution.intersection(new int[][]{
                {3,1,2,4,5},{1,2,3,4},{3,4,5,6}
        })).isEqualTo(Arrays.asList(3, 4));
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.intersection(new int[][]{
                {1,2,3},{4,5,6}
        })).isEqualTo(Collections.emptyList());
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.intersection(new int[][]{
                {7,34,45,10,12,27,13},{27,21,45,10,12,13}
        })).isEqualTo(Arrays.asList(10,12,13,27,45));
    }
}