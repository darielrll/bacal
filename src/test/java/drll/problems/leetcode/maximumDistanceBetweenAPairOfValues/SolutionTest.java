package drll.problems.leetcode.maximumDistanceBetweenAPairOfValues;

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
        int[] nums1 = new int[]{55, 30, 5, 4, 2};
        int[] nums2 = new int[]{100,20,10,10,5};

        assertThat(solution.maxDistance(nums1, nums2)).isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        int[] nums1 = new int[]{2, 2, 2};
        int[] nums2 = new int[]{10, 10, 1};

        assertThat(solution.maxDistance(nums1, nums2)).isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        int[] nums1 = new int[]{30, 29, 19, 5};
        int[] nums2 = new int[]{25, 25, 25, 25, 25};

        assertThat(solution.maxDistance(nums1, nums2)).isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        int[] nums1 = new int[]{5, 4};
        int[] nums2 = new int[]{3, 2};

        assertThat(solution.maxDistance(nums1, nums2)).isEqualTo(0);
    }
}