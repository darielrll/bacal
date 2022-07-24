package drll.problems.leetcode.SpiralMatrixIV;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        ListNode linkedList = buildLinkedList(0, 3,0,2,6,8,1,7,9,4,2,5,5,0);
        assertThat(solution.spiralMatrix(3, 5, linkedList))
                .isEqualTo(new int[][]{
                        {3,0,2,6,8},
                        {5,0,-1,-1,1},
                        {5,2,4,9,7}
                });
    }

    @Test
    void should_return_correctly_for_test_case2() {
        ListNode linkedList = buildLinkedList(0, 0,1,2);
        assertThat(solution.spiralMatrix(1, 4, linkedList))
                .isEqualTo(new int[][]{
                        {0,1,2,-1}
                });
    }

    private ListNode buildLinkedList(int startPoint, int... nums) {
        if(startPoint == nums.length - 1){
            return new ListNode(nums[startPoint]);
        }
        return new ListNode(nums[startPoint], buildLinkedList(startPoint + 1, nums));
    }
}