package drll.problems.leetcode.MergeSimilarItems;

import drll.problems.leetcode.MergeSimilarItems.Solution;
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
        assertThat(solution.mergeSimilarItems(
                new int[][]{
                        {1,1},{4,5},{3,8}
                },
                new int[][]{
                        {3,1},{1,5}
                }
        )).isEqualTo(Arrays.asList(
                Arrays.asList(1, 6),
                Arrays.asList(3, 9),
                Arrays.asList(4, 5)));
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.mergeSimilarItems(
                new int[][]{
                        {1,1},{3,2},{2,3}
                },
                new int[][]{
                        {2,1},{3,2},{1,3}
                }
        )).isEqualTo(Arrays.asList(
                Arrays.asList(1, 4),
                Arrays.asList(2, 4),
                Arrays.asList(3, 4)));
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.mergeSimilarItems(
                new int[][]{
                        {1,3},{2,2}
                },
                new int[][]{
                        {7,1},{2,2},{1,4}
                }
        )).isEqualTo(Arrays.asList(
                Arrays.asList(1, 7),
                Arrays.asList(2, 4),
                Arrays.asList(7, 1)));
    }
}