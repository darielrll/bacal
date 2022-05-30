package drll.problems.leetCodeContest.problem3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution binarySearch;

    @BeforeEach
    void init(){
        binarySearch = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(binarySearch.totalSteps(new int[]{5,3,4,4,7,3,6,11,8,5,11})).
                isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(binarySearch.totalSteps(new int[]{4,5,7,7,13})).
                isEqualTo(0);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(binarySearch.totalSteps(new int[]{10,1,2,3,4,5,6,1,2,3})).
                isEqualTo(6);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(binarySearch.totalSteps(new int[]{10,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3})).
                isEqualTo(9);
    }

    @Test
    void should_return_correctly_for_test_case5() {
        assertThat(binarySearch.totalSteps(new int[]{5,11,7,8,11})).
                isEqualTo(2);
    }
}