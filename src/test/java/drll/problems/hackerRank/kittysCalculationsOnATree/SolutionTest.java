package drll.problems.hackerRank.kittysCalculationsOnATree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void should_return_correctly_for_test_case1() {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}, {3, 7}};
        int[][] queries = new int[][]{{4, 5, 7}};

        int[] small = Solution.calculateFormula(edges, queries);

        assertThat(small).isEqualTo(new int[]{214});
    }

    @Test
    public void should_return_correctly_for_test_case2() {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}, {3, 7}};
        int[][] queries = new int[][]{{2, 4}, {5}, {2, 4, 5}};

        int[] small = Solution.calculateFormula(edges, queries);

        assertThat(small).isEqualTo(new int[]{16, 0, 106});
    }
}