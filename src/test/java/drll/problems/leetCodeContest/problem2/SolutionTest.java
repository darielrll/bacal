package drll.problems.leetCodeContest.problem2;

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
        assertThat(binarySearch.discountPrices("there are $1 $2 and 5$ candies in the shop", 50))
                .isEqualTo("there are $0.50 $1.00 and 5$ candies in the shop");
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(binarySearch.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100))
                .isEqualTo("1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$");
    }
}