package drll.problems.leetcode.binary_search_tree_to_greater_sum_tree;

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
