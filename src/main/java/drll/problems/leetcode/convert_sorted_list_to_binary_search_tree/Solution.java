package drll.problems.leetcode.convert_sorted_list_to_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int[] list = transformToArray(head);
        return buildAVL(list, 0, list.length - 1);
    }

    private TreeNode buildAVL(int[] list, int init, int end) {
        if(init > end){
            return null;
        }
        int middlePosition = (init + end) / 2;
        return new TreeNode(
                list[middlePosition],
                buildAVL(list, init, middlePosition - 1),
                buildAVL(list, middlePosition + 1, end)
        );
    }

    private int[] transformToArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}