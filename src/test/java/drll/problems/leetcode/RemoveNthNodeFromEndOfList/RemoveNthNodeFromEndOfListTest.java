package drll.problems.leetcode.RemoveNthNodeFromEndOfList;

import drll.problems.leetcode.MiddleOfTheLinkedList.binarySearch.MiddleOfTheLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RemoveNthNodeFromEndOfListTest {
    private RemoveNthNodeFromEndOfList binarySearch;

    @BeforeEach
    void init() {
        binarySearch = new RemoveNthNodeFromEndOfList();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        RemoveNthNodeFromEndOfList.ListNode root = createListNode(0, 1, 2, 3, 4, 5);

        RemoveNthNodeFromEndOfList.ListNode listModified = binarySearch.removeNthFromEnd(root, 2);

        assertTrue(compareListNodes(listModified, createListNode(0, 1, 2, 3, 5)));
    }

    @Test
    void should_return_correctly_for_test_case2() {
        RemoveNthNodeFromEndOfList.ListNode root = createListNode(0, 1);

        RemoveNthNodeFromEndOfList.ListNode listModified = binarySearch.removeNthFromEnd(root, 1);

        assertTrue(compareListNodes(listModified, createListNode()));
    }

    @Test
    void should_return_correctly_for_test_case3() {
        RemoveNthNodeFromEndOfList.ListNode root = createListNode(0, 1, 2);

        RemoveNthNodeFromEndOfList.ListNode listModified = binarySearch.removeNthFromEnd(root, 1);

        assertTrue(compareListNodes(listModified, createListNode(0, 1)));
    }

    @Test
    void should_return_correctly_for_test_case4() {
        RemoveNthNodeFromEndOfList.ListNode root = createListNode(0, 1, 2);

        RemoveNthNodeFromEndOfList.ListNode listModified = binarySearch.removeNthFromEnd(root, 2);

        assertTrue(compareListNodes(listModified, createListNode(0, 2)));
    }

    private Boolean compareListNodes(RemoveNthNodeFromEndOfList.ListNode a, RemoveNthNodeFromEndOfList.ListNode b){
        if(a == null  &&  b == null){
            return true;
        }
        return a != null && b != null && a.val == b.val && compareListNodes(a.next, b.next);
    }

    private RemoveNthNodeFromEndOfList.ListNode createListNode(int index, int... numbers) {
        if (index == numbers.length) {
            return null;
        }
        return new RemoveNthNodeFromEndOfList.ListNode(numbers[index], createListNode(index + 1, numbers));
    }

    private RemoveNthNodeFromEndOfList.ListNode createListNode() {
        return null;
    }
}