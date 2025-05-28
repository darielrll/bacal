package drll.problems.leetcode.rotate_array;

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
        int[] arrayToRotate = {1, 2, 3, 4, 5, 6, 7};

        solution.rotate(arrayToRotate, 3);

        assertThat(arrayToRotate).isEqualTo(new int[]{5, 6, 7, 1, 2, 3, 4});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        int[] arrayToRotate = {-1, -100, 3, 99};

        solution.rotate(arrayToRotate, 2);

        assertThat(arrayToRotate).isEqualTo(new int[]{3, 99, -1, -100});
    }

    @Test
    void should_return_correctly_for_test_case3() {
        int[] arrayToRotate = {-1, -100, 3, 99};

        solution.rotate(arrayToRotate, 1);

        assertThat(arrayToRotate).isEqualTo(new int[]{99, -1, -100, 3});
    }

    @Test
    void should_return_correctly_for_test_case4() {
        int[] arrayToRotate = {-1, -100, 3, 99};

        solution.rotate(arrayToRotate, 0);

        assertThat(arrayToRotate).isEqualTo(new int[]{-1, -100, 3, 99});
    }

    @Test
    void should_return_correctly_for_test_case5() {
        int[] arrayToRotate = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        solution.rotate(arrayToRotate, 2000000000);

        assertThat(arrayToRotate).isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
    }
}