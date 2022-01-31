package drll.problems.leetcode.MiddleOfTheLinkedList.binarySearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MiddleOfTheLinkedListTest {
    private MiddleOfTheLinkedList solution;

    @BeforeEach
    void init(){
        solution = new MiddleOfTheLinkedList();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        MiddleOfTheLinkedList.ListNode root = createListNode(0, 1, 2, 3, 4, 5);

        MiddleOfTheLinkedList.ListNode listNode = solution.middleNode(root);
        assertThat(listNode.val).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        MiddleOfTheLinkedList.ListNode root = createListNode(0, 1, 2, 3, 4, 5, 6);

        MiddleOfTheLinkedList.ListNode listNode = solution.middleNode(root);
        assertThat(listNode.val).isEqualTo(4);
    }

    private MiddleOfTheLinkedList.ListNode createListNode(int index, int ... numbers) {
        if(index == numbers.length){
            return null;
        }
        return new MiddleOfTheLinkedList.ListNode(numbers[index], createListNode(index + 1, numbers));
    }
}