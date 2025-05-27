package drll.problems.leetcode.binary_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private BinarySearch binarySearch;

    @BeforeEach
    void init(){
        binarySearch = new BinarySearch();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 9)).isEqualTo(4);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 2)).isEqualTo(-1);
    }
}