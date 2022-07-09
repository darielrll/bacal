package drll.problems.leetcodeContest.problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        Solution.ListNode node = buildNode(new int[]{3,0,2,6,8,1,7,9,4,2,5,5,0});

        assertThat(solution.spiralMatrix(3, 5, node))
                .isEqualTo(new int[][]{
                        {3,0,2,6,8},{5,0,-1,-1,1},{5,2,4,9,7}
                });
    }

    @Test
    void should_return_correctly_for_test_case2() {
        Solution.ListNode node = buildNode(new int[]{0,1,2});

        assertThat(solution.spiralMatrix(1, 4, node))
                .isEqualTo(new int[][]{
                        {0,1,2,-1}
                });
    }

    private Solution.ListNode buildNode(int[] ints) {
        Solution.ListNode head = new Solution.ListNode(ints[0]);
        Solution.ListNode current = head;


        for (int i = 1; i < ints.length; i++) {
            Solution.ListNode tmp = new Solution.ListNode(ints[i]);
            current.next = tmp;
            current = tmp;
        }

        return head;
    }
}