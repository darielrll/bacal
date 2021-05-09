package drll.problems.leetcode.superPalindromes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeNumberTest {
    private PalindromeNumber palindromeNumber;

    @BeforeEach
    public void init(){
        palindromeNumber = new PalindromeNumber();
    }

    @Test
    void should_return_first_9_palindrome_number() {
        int[] palindromesExpected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertThat(palindromeNumber.getFirstPalindromeNumber(9)).isEqualTo(palindromesExpected);
    }
}