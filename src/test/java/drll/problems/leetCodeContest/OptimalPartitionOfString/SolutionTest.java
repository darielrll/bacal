package drll.problems.leetCodeContest.OptimalPartitionOfString;

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
        assertThat(solution.partitionString( "abacaba")).isEqualTo(4);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.partitionString( "ssssss")).isEqualTo(6);
    }
}