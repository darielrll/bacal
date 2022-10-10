package drll.problems.leetCodeContest.SortThePeople;

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
        assertThat(solution.sortPeople(new String[]{"Mary","John","Emma"},
                new int[]{180,165,170}))
                .isEqualTo(new String[]{"Mary","Emma","John"});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.sortPeople(new String[]{"Alice","Bob","Bob"},
                new int[]{155,185,150}))
                .isEqualTo(new String[]{"Bob","Alice","Bob"});
    }
}