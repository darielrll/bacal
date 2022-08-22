package drll.problems.leetcode.AmountOfTimeForBinaryTreeToBeInfected;

import drll.problems.leetcode.AmountOfTimeForBinaryTreeToBeInfected.Solution;
import drll.problems.leetcode.AmountOfTimeForBinaryTreeToBeInfected.TreeNode;
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
        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        5,
                        null,
                        new TreeNode(
                                4,
                                new TreeNode(9),
                                new TreeNode(2))
                ),
                new TreeNode(
                        3,
                        new TreeNode(10),
                        new TreeNode(6)
                )
        );

        assertThat(solution.amountOfTime(root, 3)).isEqualTo(4);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        TreeNode root = new TreeNode(1);

        assertThat(solution.amountOfTime(root, 1)).isEqualTo(0);
    }
}