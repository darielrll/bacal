package drll.problems.leetcode.sort_the_jumbled_numbers;

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
        assertThat(solution.sortJumbled(
                new int[]{8,9,4,0,2,1,3,5,7,6},
                new int[]{991,338,38}))
                .isEqualTo(new int[]{338,38,991});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.sortJumbled(
                new int[]{0,1,2,3,4,5,6,7,8,9},
                new int[]{789,456,123}))
                .isEqualTo(new int[]{123,456,789});
    }
}