package drll.problems.custom.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortTest {
    private MergeSort mergeSort;

    @BeforeEach
    void init(){
        mergeSort = new MergeSort();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        int[] unsortedArray = new int[]{4, 3, 2, 1};
        int[] expectedSort = new int[]{1, 2, 3, 4};

        assertThat(mergeSort.mergeSort(unsortedArray)).isEqualTo(expectedSort);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        int[] unsortedArray = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expectedSort = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertThat(mergeSort.mergeSort(unsortedArray)).isEqualTo(expectedSort);
    }
}