package drll.problems.leetCodeContest.problem3;

import common.Utils;
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
        assertThat(solution.countSubarrays(new int[]{2, 1, 4, 3, 5}, 10))
                .isEqualTo(6);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.countSubarrays(new int[]{1, 1, 1}, 5))
                .isEqualTo(5);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        String testDataFile = "countSubArraysWithScoreLessThanK/testCase1.txt";
        int[] nums = Utils.buildArrayIntFromFile(testDataFile, ",");

        assertThat(solution.countSubarrays(nums, 648711103885421L))
                .isEqualTo(643418128L);
    }
}