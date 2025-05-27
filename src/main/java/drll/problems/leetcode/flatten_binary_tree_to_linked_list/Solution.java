package drll.problems.leetcode.flatten_binary_tree_to_linked_list;

import drll.problems.leetcode.binary_search_tree_to_greater_sum_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        linkedListToArray(root, nodeList);
        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).left = null;
            nodeList.get(i).right = nodeList.get(i + 1);
        }
    }

    private void linkedListToArray(TreeNode node, List<TreeNode> list) {
        if(node == null){
            return;
        }
        list.add(node);
        linkedListToArray(node.left, list);
        linkedListToArray(node.right, list);
    }

}