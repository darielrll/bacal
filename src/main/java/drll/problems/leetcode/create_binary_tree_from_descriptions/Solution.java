package drll.problems.leetcode.create_binary_tree_from_descriptions;

import java.util.HashMap;

public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> reference = new HashMap<>();
        HashMap<Integer, Integer> referenceFathers = new HashMap<>();
        TreeNode root = null;

        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;

            referenceFathers.put(child, parent);

            TreeNode parentNode, childNode;

            if (reference.containsKey(parent)) {
                parentNode = reference.get(parent);
            } else {
                parentNode = new TreeNode(parent);
                reference.put(parent, parentNode);
            }

            if (reference.containsKey(child)) {
                childNode = reference.get(child);
            } else {
                childNode = new TreeNode(child);
                reference.put(child, childNode);
            }

            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            if (root == null) {
                root = parentNode;
            } else {
                if (childNode.val == root.val) {
                    root = parentNode;
                    while (referenceFathers.containsKey(root.val)) {
                        root = reference.get(referenceFathers.get(root.val));
                    }
                }
            }
        }

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}