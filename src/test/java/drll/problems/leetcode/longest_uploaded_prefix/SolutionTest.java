package drll.problems.leetcode.longest_uploaded_prefix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void should_return_correctly_for_test_case1() {
        LUPrefix luPrefix = new LUPrefix(4);

        luPrefix.upload(3);
        assertEquals(0, luPrefix.longest());
        luPrefix.upload(1);
        assertEquals(1, luPrefix.longest());
        luPrefix.upload(2);

    }

    @Test
    void should_return_correctly_for_test_case2() {
        LUPrefix luPrefix = new LUPrefix(10);

        assertEquals(0, luPrefix.longest());
        luPrefix.upload(6);
        assertEquals(0, luPrefix.longest());
        luPrefix.upload(10);
        luPrefix.upload(7);
        luPrefix.upload(4);
        assertEquals(0, luPrefix.longest());
        luPrefix.upload(2);
        assertEquals(0, luPrefix.longest());
        luPrefix.upload(8);
        luPrefix.upload(3);
        luPrefix.upload(1);
    }
}