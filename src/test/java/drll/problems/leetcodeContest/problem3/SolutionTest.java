package drll.problems.leetcodeContest.problem3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init() {
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        Solution.TreeNode expectedBinaryTree = new Solution.TreeNode(
                50,
                new Solution.TreeNode(20,
                        new Solution.TreeNode(15),
                        new Solution.TreeNode(17)),
                new Solution.TreeNode(80,
                        new Solution.TreeNode(19),
                        null)
        );


        Solution.TreeNode binaryTree = solution.createBinaryTree(
                new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}}
        );
        assertTrue(areEqualBinaryTree(binaryTree, expectedBinaryTree));
    }

    @Test
    void should_return_correctly_for_test_case2() {
        Solution.TreeNode expectedBinaryTree = new Solution.TreeNode(
                1,
                new Solution.TreeNode(2,
                        null,
                        new Solution.TreeNode(3,
                                new Solution.TreeNode(4),
                                null)),
                null
        );


        Solution.TreeNode binaryTree = solution.createBinaryTree(
                new int[][]{{1,2,1}, {2,3,0}, {3,4,1}}
        );
        assertTrue(areEqualBinaryTree(binaryTree, expectedBinaryTree));
    }

    @Test
    void should_return_correctly_for_test_case3() {
        Solution.TreeNode expectedBinaryTree = new Solution.TreeNode(
                1,
                new Solution.TreeNode(2,
                        null,
                        new Solution.TreeNode(3,
                                new Solution.TreeNode(4),
                                null)),
                null
        );


        Solution.TreeNode binaryTree = solution.createBinaryTree(
                new int[][]{{39,70,1},{13,39,1},{85,74,1},{74,13,1},{38,82,1},{82,85,1}}
        );
        assertTrue(areEqualBinaryTree(binaryTree, expectedBinaryTree));
    }

    private boolean areEqualBinaryTree(Solution.TreeNode tree1, Solution.TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (tree1.val != tree2.val) {
            return false;
        }
        return areEqualBinaryTree(tree1.left, tree2.left)  &&
                areEqualBinaryTree(tree1.right, tree2.right);
    }
}