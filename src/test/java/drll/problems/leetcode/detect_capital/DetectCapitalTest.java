package drll.problems.leetcode.detect_capital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DetectCapitalTest {
    private DetectCapital detectCapital;

    @BeforeEach
    void init(){
        detectCapital = new DetectCapital();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertTrue(detectCapital.detectCapitalUse("USA"));
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertFalse(detectCapital.detectCapitalUse("FlaG"));
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertTrue(detectCapital.detectCapitalUse("Google"));
    }
}