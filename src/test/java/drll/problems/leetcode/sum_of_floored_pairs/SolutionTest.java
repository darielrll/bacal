package drll.problems.leetcode.sum_of_floored_pairs;

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
        assertThat(solution.sumOfFlooredPairs(new int[]{2, 5, 9}))
                .isEqualTo(10);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.sumOfFlooredPairs(new int[]{7, 7, 7, 7, 7, 7, 7}))
                .isEqualTo(49);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.sumOfFlooredPairs(new int[]{4, 3, 4, 3, 5}))
                .isEqualTo(17);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.sumOfFlooredPairs(new int[]{4, 1, 1, 2, 4}))
                .isEqualTo(33);
    }

    @Test
    void should_return_correctly_for_test_case5() {
        String testDataFile = "leetcode/sumOfFlooredPairs/testCase5.txt";
        int[] nums = Utils.buildArrayIntFromFile(testDataFile, ",");

        assertThat(solution.sumOfFlooredPairs(nums)).isEqualTo(703074513);
    }
}