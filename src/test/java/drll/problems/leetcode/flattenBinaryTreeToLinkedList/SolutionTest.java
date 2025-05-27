package drll.problems.leetcode.flattenBinaryTreeToLinkedList;

import drll.problems.leetcode.binary_search_tree_to_greater_sum_tree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)),
                new TreeNode(5,
                        null,
                        new TreeNode(6)));

        solution.flatten(node);

        assertThat(isALinkedList(node)).isTrue();
        assertThat(linkedListLength(node)).isEqualTo(6);
        assertThat(linkedListToArray(node)).isEqualTo(new Integer[]{1, 2, 3, 4, 5, 6});
    }

    private Integer[] linkedListToArray(TreeNode node) {
        return linkedListToArray(node, new ArrayList<>());
    }

    private Integer[] linkedListToArray(TreeNode node, List<Integer> list) {
        if(node == null){
            return list.toArray(new Integer[0]);
        }
        list.add(node.val);
        return linkedListToArray(node.right, list);
    }

    private int linkedListLength(TreeNode node) {
        if(node == null){
            return 0;
        }
        return 1 + linkedListLength(node.right);
    }

    private boolean isALinkedList(TreeNode node) {
        if(node == null){
            return true;
        }
        if(node.left != null){
            return false;
        }
        return isALinkedList(node.right);
    }
}