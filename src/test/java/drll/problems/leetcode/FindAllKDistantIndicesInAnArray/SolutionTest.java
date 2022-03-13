package drll.problems.leetcode.FindAllKDistantIndicesInAnArray;

import drll.problems.leetcode.FindAllKDistantIndicesInAnArray.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(solution.findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9 , 1))
                .isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.findKDistantIndices(new int[]{2,2,2,2,2}, 2 , 2))
                .isEqualTo(Arrays.asList(0,1,2,3,4));
    }
}