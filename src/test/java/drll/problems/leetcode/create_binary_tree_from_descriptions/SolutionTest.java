package drll.problems.leetcode.create_binary_tree_from_descriptions;

import drll.problems.leetcode.create_binary_tree_from_descriptions.Solution.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init() {
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        TreeNode expectedBinaryTree = new TreeNode(
                50,
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(17)),
                new TreeNode(80,
                        new TreeNode(19),
                        null)
        );


        TreeNode binaryTree = solution.createBinaryTree(
                new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}}
        );
        assertTrue(areEqualBinaryTree(binaryTree, expectedBinaryTree));
    }

    @Test
    void should_return_correctly_for_test_case2() {
        TreeNode expectedBinaryTree = new TreeNode(
                1,
                new TreeNode(2,
                        null,
                        new TreeNode(3,
                                new TreeNode(4),
                                null)),
                null
        );


        TreeNode binaryTree = solution.createBinaryTree(
                new int[][]{{1,2,1}, {2,3,0}, {3,4,1}}
        );
        assertTrue(areEqualBinaryTree(binaryTree, expectedBinaryTree));
    }

    @Test
    void should_return_correctly_for_test_case3() {
        TreeNode expectedBinaryTree = new TreeNode(38,
                new TreeNode(82,
                        new TreeNode(85,
                                new TreeNode(74,
                                        new TreeNode(13,
                                                new TreeNode(39,
                                                        new TreeNode(70),
                                                        null),
                                                null),
                                        null),
                                null),
                        null),
                null);


        TreeNode binaryTree = solution.createBinaryTree(
                new int[][]{{39,70,1},{13,39,1},{85,74,1},{74,13,1},{38,82,1},{82,85,1}}
        );
        assertTrue(areEqualBinaryTree(binaryTree, expectedBinaryTree));
    }

    private boolean areEqualBinaryTree(TreeNode tree1, TreeNode tree2) {
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