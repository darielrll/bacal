package drll.problems.leetcode.middle_of_the_linkedlist.binary_search;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        return getNodeAt(getLength(head) / 2, head);
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