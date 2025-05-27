package drll.problems.leetcode.evaluate_boolean_binary_tree;

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
        Solution.TreeNode tree = new Solution.TreeNode(
                2,
                new Solution.TreeNode(1),
                new Solution.TreeNode(3,
                        new Solution.TreeNode(0),
                        new Solution.TreeNode(1))
        );

        assertThat(solution.evaluateTree(tree)).isTrue();
    }

    @Test
    void should_return_correctly_for_test_case2() {
        Solution.TreeNode tree = new Solution.TreeNode(0);

        assertThat(solution.evaluateTree(tree)).isFalse();
    }
}