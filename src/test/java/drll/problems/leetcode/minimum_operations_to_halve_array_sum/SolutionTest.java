package drll.problems.leetcode.minimum_operations_to_halve_array_sum;

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
        assertThat(solution.halveArray(new int[]{5,19,8,1})).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.halveArray(new int[]{3,8,20})).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.halveArray(new int[]{6,58,10,84,35,8,22,64,1,78,86,71,77})).isEqualTo(9);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.halveArray(new int[]{32,98,23,14,67,40,26,9,96,96,91,
                76,4,40,42,2,31,13,16,37,62,2,27,25,100,94,14,3,48,56,64,59,33,
                10,74,47,73,72,89,69,15,79,22,18,53,62,20,9,76,64})).isEqualTo(36);
    }

    @Test
    void should_return_correctly_for_test_case5() {
        assertThat(solution.halveArray(new int[]{18,22,62,61,1,88,17,98,38,32,
                51,57,7,29,40,61,62,13,89,41,73,85,88,60,59,76,71,76,76,41,29,
                43,19,9,79})).isEqualTo(29);
    }
}