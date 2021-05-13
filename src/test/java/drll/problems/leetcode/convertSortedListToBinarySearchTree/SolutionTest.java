package drll.problems.leetcode.convertSortedListToBinarySearchTree;

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
        ListNode linkedList = buildLinkedList(0, -10, -3, 0, 5, 9);

        TreeNode treeNode = solution.sortedListToBST(linkedList);

        assertThat(isAVLTree(treeNode)).isTrue();
    }

    @Test
    void should_return_correctly_for_test_case2() {
        TreeNode treeNode = solution.sortedListToBST(null);

        assertThat(treeNode).isNull();
    }

    @Test
    void should_return_correctly_for_test_case3() {
        ListNode linkedList = buildLinkedList(0, 0);

        TreeNode treeNode = solution.sortedListToBST(linkedList);

        assertThat(isAVLTree(treeNode)).isTrue();
    }

    @Test
    void should_return_correctly_for_test_case4() {
        ListNode linkedList = buildLinkedList(0, 1, 3);

        TreeNode treeNode = solution.sortedListToBST(linkedList);

        assertThat(isAVLTree(treeNode)).isTrue();
    }

    private ListNode buildLinkedList(int startPoint, int... nums) {
        if(startPoint == nums.length - 1){
            return new ListNode(nums[startPoint]);
        }
        return new ListNode(nums[startPoint], buildLinkedList(startPoint + 1, nums));
    }

    private boolean isAVLTree(TreeNode treeNode) {
        AVLTreeNode avl = buildAVLTree(treeNode);
        return isAVL(avl);
    }

    private boolean isAVL(AVLTreeNode avl) {
        if(avl == null){
            return true;
        }
        int leftHight = avl.left == null ? 0 : avl.left.height;
        int rightHight = avl.right == null ? 0 : avl.right.height;
        if(Math.abs(leftHight - rightHight) > 1){
            return false;
        }
        if(avl.left != null  &&  avl.node.val < avl.left.node.val){
            return false;
        }
        if(avl.right != null  &&  avl.node.val > avl.right.node.val){
            return false;
        }
        return isAVL(avl.left)  &&  isAVL(avl.right);
    }

    private AVLTreeNode buildAVLTree(TreeNode treeNode) {
        if(treeNode == null){
            return null;
        }
        AVLTreeNode avl = new AVLTreeNode(
                treeNode,
                buildAVLTree(treeNode.left),
                buildAVLTree(treeNode.right));
        avl.height = 1 + Math.max(
                avl.left == null ? 0 : avl.left.height,
                avl.right == null ? 0 : avl.right.height
        );
        return avl;
    }
}

class AVLTreeNode{
    TreeNode node;
    int height;

    AVLTreeNode left, right;

    AVLTreeNode(TreeNode node, AVLTreeNode left, AVLTreeNode right) {
        this.node = node;
        this.left = left;
        this.right = right;
    }
}