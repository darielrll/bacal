package drll.problems.leetcode.valid_digit_number;


import drll.problems.leetcode.valid_digit_number.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    private Solution validDigitNumber;

    @BeforeEach
    void init(){
        validDigitNumber = new Solution();
    }

    @Test
    void should_return_true_when_n_contains_x() {
        assertTrue(validDigitNumber.validDigit(101, 0));
    }

    @Test
    void should_return_false_when_n_start_with_x() {
        assertFalse(validDigitNumber.validDigit(101, 1));
    }

    @Test
    void should_return_false_when_n_not_contains_x() {
        assertFalse(validDigitNumber.validDigit(101, 2));
    }
}