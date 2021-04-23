package drll.problems.leetcode.binarySearchTreeToGreaterSumTree;

public class Solution {
    int accumulate = 0;

    public TreeNode bstToGst(TreeNode root) {
        updateNodeValue(root);
        return root;
    }

    private void updateNodeValue(TreeNode node){
        if(node == null){
            return;
        }
        updateNodeValue(node.right);

        accumulate += node.val;
        node.val = accumulate;

        updateNodeValue(node.left);
    }
}
