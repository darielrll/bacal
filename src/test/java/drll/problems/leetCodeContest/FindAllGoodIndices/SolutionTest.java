package drll.problems.leetCodeContest.FindAllGoodIndices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(solution.goodIndices(new int[]{2,1,1,1,3,4,1}, 2)).
                isEqualTo(Arrays.asList(2, 3));
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.goodIndices(new int[]{2,1,1,2}, 2)).
                isEqualTo(Collections.emptyList());
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.goodIndices(new int[]{877464,394689,51354,348332,285490,570624}, 2)).
                isEqualTo(Arrays.asList(3));
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.goodIndices(new int[]{440043,276285,336957}, 1)).
                isEqualTo(Arrays.asList(1));
    }

    @Test
    void should_return_correctly_for_test_case5() {
        assertThat(solution.goodIndices(new int[]{4,2,3}, 1)).
                isEqualTo(Arrays.asList(1));
    }

    @Test
    void should_return_correctly_for_test_case6() {
        assertThat(solution.goodIndices(new int[]{123592,303692,752301,522418,100,
                68,12,12,11,7,3,2,1,1,1,1,1,1,1,477952,882691,945349,997202,999245,
                999319,999911,999913,999985,999996,999996,999996,1000000,1000000,
                1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,
                1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,
                1000000,1000000,1000000,482896,250330,20230,570399,972746,999408}, 12)).
                isEqualTo(Arrays.asList(14,15,16,17,18,19));
    }

    @Test
    void should_return_correctly_for_test_case7() {
        assertThat(solution.goodIndices(new int[]{8,4,3,5,8,5,10}, 2)).
                isEqualTo(Arrays.asList(2));
    }

    @Test
    void should_return_correctly_for_test_case8() {
        assertThat(solution.goodIndices(new int[]{478184,863008,716977,921182,182844,350527,541165,881224}, 1)).
                isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
}