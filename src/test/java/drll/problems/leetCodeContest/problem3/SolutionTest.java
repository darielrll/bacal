package drll.problems.leetCodeContest.problem3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(solution.testNumberContainer(
                new String[]{"NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"},
                new int[][]{{},{10},{2, 10},{1, 10},{3, 10},{5, 10},{10},{1, 20},{10}}
        )).isEqualTo(new Object[]{null, -1, null, null, null, null, 1, null, 2});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.testNumberContainer(
                new String[]{"NumberContainers","change","find","change","find","find","find"},
                new int[][]{{},{1,10},{10},{1, 20},{10},{20},{30}}
        )).isEqualTo(new Object[]{null, null, 1, null, -1, 1, -1});
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.testNumberContainer(
                new String[]{"NumberContainers","change","change","find","change","find"},
                new int[][]{{},{1,10},{1, 10},{10},{1, 20},{10}}
        )).isEqualTo(new Object[]{null, null, null, 1, null, -1});
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.testNumberContainer(
                new String[]{"NumberContainers","change","change","find","find","find","change","find","find","change","find","change","change","change","find","find","change","find","change","change","change"},
                new int[][]{{},{25,50},{56,31},{50},{50},{43},{30,50},{31},{43},{25,20},{50},{56,43},{68,31},{56,31},{20},{43},{25,43},{43},{56,31},{54,43},{63,43}}
        )).isEqualTo(new Object[]{null,null,null,25,25,-1,null,56,-1,null,30,null,null,null,25,-1,null,25,null,null,null});
    }

    @Test
    void should_return_correctly_for_test_case5() {
        assertThat(solution.testNumberContainer(
                new String[]{"NumberContainers","change","find","find","find","change","change","change","change","change","change","change","change","change","find","change","find","find","change","find","change"},
                new int[][]{{},{75,40},{14},{41},{40},{27,40},{22,14},{85,14},{22,40},{18,34},{92,41},{22,40},{75,40},{59,34},{40},{27,14},{34},{14},{13,34},{40},{18,41}}
        )).isEqualTo(new Object[]{null,null,-1,-1,75,null,null,null,null,null,null,null,null,null,22,null,18,27,null,22,null});
    }
}