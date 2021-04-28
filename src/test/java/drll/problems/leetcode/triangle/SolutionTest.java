package drll.problems.leetcode.triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void init(){
        solution = new Solution();
    }

    @Test
    public void should_return_correctly_for_test_case1() {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>(){{
            add(Arrays.asList(2));
            add(Arrays.asList(3,4));
            add(Arrays.asList(6,5,7));
            add(Arrays.asList(4,1,8,3));
        }};

        Integer minimunPath = solution.minimumTotal(triangle);

        assertThat(minimunPath).isEqualTo(11);
    }

    @Test
    public void should_return_correctly_for_test_case2() {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>(){{
            add(Arrays.asList(-10));
        }};

        Integer minimunPath = solution.minimumTotal(triangle);

        assertThat(minimunPath).isEqualTo(-10);
    }
}