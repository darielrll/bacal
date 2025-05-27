package drll.problems.leetcode.count_collisions_on_a_road;

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
        assertThat(solution.countCollisions( "RLRSLL")).isEqualTo(5);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.countCollisions( "LLRR")).isEqualTo(0);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.countCollisions( "LSSSLLSSSSLRRSLLLSLSLRRLLLLLRSSRSRRSLLLSSS"))
                .isEqualTo(24);
    }
}