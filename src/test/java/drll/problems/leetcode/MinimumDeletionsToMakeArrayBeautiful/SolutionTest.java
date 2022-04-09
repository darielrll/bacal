package drll.problems.leetcode.MinimumDeletionsToMakeArrayBeautiful;

import drll.problems.leetcode.MinimumDeletionsToMakeArrayBeautiful.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    //TODO: casos de longitud 1 y de longitud 2

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(solution.minDeletion(new int[]{1,1,2,3,5})).isEqualTo(1);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.minDeletion(new int[]{1,1,2,2,3,3})).isEqualTo(2);
    }

    @Test
    void should_return_0_deletions_for_an_empty_array() {
        assertThat(solution.minDeletion(new int[]{})).isZero();
    }

    @Test
    void should_return_1_deletions_for_an_array_of_length_1() {
        assertThat(solution.minDeletion(new int[]{2})).isEqualTo(1);
    }

    @Test
    void should_return_2_deletions_for_an_array_of_length_2_and_all_elements_equals() {
        assertThat(solution.minDeletion(new int[]{1, 1})).isEqualTo(2);
    }

    @Test
    void should_return_2_deletions_for_an_array_of_length_2_and_all_elements_distinct() {
        assertThat(solution.minDeletion(new int[]{1, 4})).isZero();
    }

    @Test
    void should_return_3_deletions_for_an_array_of_length_3_and_all_elements_equals() {
        assertThat(solution.minDeletion(new int[]{2,2,2})).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.minDeletion(new int[]{0,1,5,4,2,4,7,2,3,0,3,
                0,0,9,7,5,9,4,3,9,9,2,1,6,3,1,0,7,6,6,6,0,1,7,1,9,4,9,3,
                3,4,5,0,3,8,7,1,8,4,5})).isEqualTo(4);
    }
}