package drll.problems.leetcode.remove_nth_node_from_end_of_list;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int positionToRemove = getLength(head) - n;
        if(positionToRemove == 0){
            return head.next;
        }
        if(positionToRemove < 0){
            return null;
        }
        ListNode nodeBeforeRemove = getNodeAt(positionToRemove - 1, head);
        nodeBeforeRemove.next = nodeBeforeRemove.next.next;

        return head;
    }

    private int getLength(ListNode head){
        if(head == null){
            return 0;
        }
        return 1 + getLength(head.next);
    }

    private ListNode getNodeAt(int index, ListNode head){
        if(index == 0){
            return head;
        }
        return getNodeAt(index - 1, head.next);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}