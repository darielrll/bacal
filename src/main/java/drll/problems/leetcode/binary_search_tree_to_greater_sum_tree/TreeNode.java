package drll.problems.leetcode.binary_search_tree_to_greater_sum_tree;

public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
