package drll.problems.leetcode.CellsInARangeOnAnExcelSheet;

import drll.problems.leetcode.CellsInARangeOnAnExcelSheet.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        List<String> cellsInRangeExpected = Arrays.asList("K1","K2","L1","L2");

        assertThat(solution.cellsInRange("K1:L2")).isEqualTo(cellsInRangeExpected);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        List<String> cellsInRangeExpected = Arrays.asList("A1","B1","C1","D1","E1","F1");

        assertThat(solution.cellsInRange("A1:F1")).isEqualTo(cellsInRangeExpected);
    }
}