package drll.problems.leetcode.compare_sums_of_bitonic_parts;

import drll.problems.leetcode.compare_sums_of_bitonic_parts.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution compareSumsOfBitnicParts;

    @BeforeEach
    void init(){
        compareSumsOfBitnicParts = new Solution();
    }

    @Test
    void should_return_1_for_first_case() {
        assertEquals(1, compareSumsOfBitnicParts.compareBitonicSums(new int[]{1, 3, 2, 1}));
    }

    @Test
    void should_return_0_for_second_case() {
        assertEquals(0, compareSumsOfBitnicParts.compareBitonicSums(new int[]{2, 4, 5, 2}));
    }

    @Test
    void should_return_minus_1_for_third_case() {
        assertEquals(-1, compareSumsOfBitnicParts.compareBitonicSums(new int[]{1, 2, 4, 3}));
    }

    @Test
    void should_return_minus_1_for_first_custom_case() {
        assertEquals(1, compareSumsOfBitnicParts.compareBitonicSums(new int[]{1, 2, 4, 3, 2, 1}));
    }

    @Test
    void should_return_0_for_online_judge_case_544() {
        assertEquals(1, compareSumsOfBitnicParts.compareBitonicSums(new int[]{30494606,875031872,850559628,844602130}));
    }
}