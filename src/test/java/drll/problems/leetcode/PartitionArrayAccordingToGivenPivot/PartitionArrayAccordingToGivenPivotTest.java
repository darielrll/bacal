package drll.problems.leetcode.PartitionArrayAccordingToGivenPivot;

import drll.problems.leetcode.partition_array_according_to_given_pivot.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PartitionArrayAccordingToGivenPivotTest {
    private Solution problem2;

    @BeforeEach
    void init(){
        problem2 = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(problem2.pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10))
                .isEqualTo(new int[]{9, 5, 3, 10, 10, 12, 14});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(problem2.pivotArray(new int[]{-3, 4, 3, 2}, 2))
                .isEqualTo(new int[]{-3, 2, 4, 3});
    }
}