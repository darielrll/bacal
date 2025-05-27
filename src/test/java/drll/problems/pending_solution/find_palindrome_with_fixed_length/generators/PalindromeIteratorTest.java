package drll.problems.pending_solution.find_palindrome_with_fixed_length.generators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeIteratorTest {
    private PalindromeNumberIterator palindromeIterator;

    @BeforeEach
    void init() {
        palindromeIterator = new PalindromeNumberIterator();
    }

    @Test
    @Disabled
    void should_return_true_has_next_palindrome() {
        assertThat(palindromeIterator.hasNext()).isTrue();
    }

    @Test
    @Disabled
    void should_return_current_palindrome() {
        String palindrome = palindromeIterator.next();

        assertThat(palindromeIterator.currentPalindrome()).isEqualTo(palindrome);
    }

    @Test
    @Disabled
    void should_init_generator_at_a_given_number_palindrome() {
        palindromeIterator = new PalindromeNumberIterator("101");

        assertThat(palindromeIterator.currentPalindrome()).isEqualTo("101");
    }

    @Test
    @Disabled
    void should_return_palindrome_1_for_a_new_palindrome_genertor() {
        assertThat(palindromeIterator.next()).isEqualTo("1");
    }

    @Test
    @Disabled
    void should_return_palindrome_2_as_a_second_palindrome() {
        palindromeIterator.next();
        assertThat(palindromeIterator.next()).isEqualTo("2");
    }

    @Test
    @Disabled
    void should_return_first_nine_palindromes_of_length_1() {
        for (int i = 0; i < 9; i++) {
            assertThat(palindromeIterator.next()).isEqualTo(String.valueOf(i + 1));
        }
    }

    @Test
    @Disabled
    void should_return_11_as_a_first_palindromes_of_length_2() {
        for (int i = 0; i < 9; i++) {
            palindromeIterator.next();
        }

        assertThat(palindromeIterator.next()).isEqualTo("11");
    }

    @Test
    @Disabled
    void should_return_22_as_a_second_palindromes_of_length_2() {
        for (int i = 0; i < 9; i++) {
            palindromeIterator.next();
        }
        palindromeIterator.next();

        assertThat(palindromeIterator.next()).isEqualTo("22");
    }

    @Test
    @Disabled
    void should_return_nine_palindromes_of_length_2() {
        for (int i = 0; i < 9; i++) {
            palindromeIterator.next();
        }

        assertThat(palindromeIterator.next()).isEqualTo("11");
        assertThat(palindromeIterator.next()).isEqualTo("22");
        assertThat(palindromeIterator.next()).isEqualTo("33");
        assertThat(palindromeIterator.next()).isEqualTo("44");
        assertThat(palindromeIterator.next()).isEqualTo("55");
        assertThat(palindromeIterator.next()).isEqualTo("66");
        assertThat(palindromeIterator.next()).isEqualTo("77");
        assertThat(palindromeIterator.next()).isEqualTo("88");
        assertThat(palindromeIterator.next()).isEqualTo("99");
    }

    @Test
    @Disabled
    void should_return_101_as_first_palindromes_of_length_3() {
        for (int i = 0; i < 18; i++) {
            palindromeIterator.next();
        }

        assertThat(palindromeIterator.next()).isEqualTo("101");
    }

    @Test
    @Disabled
    void should_return_202_when_current_palindrome_is_191() {
        palindromeIterator = new PalindromeNumberIterator("191");

        assertThat(palindromeIterator.next()).isEqualTo("202");
    }
}