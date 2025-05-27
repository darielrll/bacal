package drll.problems.leetcode.binary_search_tree_to_greater_sum_tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        Integer[] treeValues = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};

        TreeNode tree = solution.bstToGst(buildTree(treeValues));

        Integer[] treeExpected = {30,36,21,36,35,26,15,null,null,null,33,null,null,null,8};
        Integer[] actual = buildTreeValues(tree);
        assertThat(actual).isEqualTo(treeExpected);
    }

    private TreeNode buildTree(Integer[] nodeRows){
        return visitAllTreeNodes(nodeRows, 0);
    }

    private TreeNode visitAllTreeNodes(Integer[] nodeRows, Integer currentNode){
        if(isNotValidNodePosition(nodeRows, currentNode)  ||  nodeRows[currentNode] == null){
            return null;
        }
        return new TreeNode(nodeRows[currentNode],
                visitAllTreeNodes(nodeRows, getLeftChildNode(currentNode)),
                visitAllTreeNodes(nodeRows, getRightChildNode(currentNode)));
    }

    private boolean isNotValidNodePosition(Integer[] nodeRows, Integer currentNode) {
        return currentNode < 0 || currentNode >= nodeRows.length;
    }

    private Integer getRightChildNode(Integer nodePosition) {
        return 2 * (nodePosition + 1);
    }

    private Integer getLeftChildNode(Integer nodePosition) {
        return 2 * nodePosition + 1;
    }

    private Integer[] buildTreeValues(TreeNode tree){
        Integer[] treeValues = new Integer[getBalancedNodesCount(tree)];
        mapTreeToIntegerArray(treeValues, tree, 0);
        return treeValues;
    }

    private void mapTreeToIntegerArray(Integer[] treeValues, TreeNode node, Integer position){
        if(node == null){
            return;
        }
        treeValues[position] = node.val;
        mapTreeToIntegerArray(treeValues, node.left, getLeftChildNode(position));
        mapTreeToIntegerArray(treeValues, node.right, getRightChildNode(position));
    }

    private int getBalancedNodesCount(TreeNode tree) {
        int treeHigh = getTreeHigh(tree);
        int nodesCount = 0;
        for(int i = 0; i < treeHigh; i++){
            nodesCount += (int)Math.pow(2, i);
        }
        return nodesCount;
    }

    private int getTreeHigh(TreeNode tree) {
        if(tree == null){
            return 0;
        }
        return Math.max(1 + getTreeHigh(tree.left), 1 + getTreeHigh(tree.right));
    }
}