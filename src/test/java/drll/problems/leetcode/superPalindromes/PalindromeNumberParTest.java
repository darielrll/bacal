package drll.problems.leetcode.superPalindromes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class PalindromeNumberParTest {

//    @Test
//    void should_throw_exception_intializing_with_odd_number() {
//        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new PalindromeNumberPar(2));
//        assertThat(illegalArgumentException.getMessage()).isEqualTo("Init parameter should be par");
//    }

    @Test
    void should_return_11_as_first_palindrome_number_par_with_2_digits() {
        PalindromeNumberPar palindromeNumberPar = new PalindromeNumberPar(2);
        Integer palindrome = palindromeNumberPar.next();

        assertThat(palindrome).isEqualTo(11);
        assertThat(esPalindromeNumber(palindrome)).isTrue();
    }

    @Test
    void should_return_all_palindrome_number_par_with_2_digits() {
        PalindromeNumberPar palindromeNumberPar = new PalindromeNumberPar(2);

        Integer palindrome = palindromeNumberPar.next();
        assertThat(palindrome).isEqualTo(11);
        assertThat(esPalindromeNumber(palindrome)).isTrue();

        palindrome = palindromeNumberPar.next();
        assertThat(palindrome).isEqualTo(22);
        assertThat(esPalindromeNumber(palindrome)).isTrue();

        palindrome = palindromeNumberPar.next();
        assertThat(palindrome).isEqualTo(33);
        assertThat(esPalindromeNumber(palindrome)).isTrue();

        palindrome = palindromeNumberPar.next();
        assertThat(palindrome).isEqualTo(44);
        assertThat(esPalindromeNumber(palindrome)).isTrue();

        palindrome = palindromeNumberPar.next();
        assertThat(palindrome).isEqualTo(55);
        assertThat(esPalindromeNumber(palindrome)).isTrue();

        palindrome = palindromeNumberPar.next();
        assertThat(palindrome).isEqualTo(66);
        assertThat(esPalindromeNumber(palindrome)).isTrue();

        palindrome = palindromeNumberPar.next();
        assertThat(palindrome).isEqualTo(77);
        assertThat(esPalindromeNumber(palindrome)).isTrue();

        palindrome = palindromeNumberPar.next();
        assertThat(palindrome).isEqualTo(88);
        assertThat(esPalindromeNumber(palindrome)).isTrue();

        palindrome = palindromeNumberPar.next();
        assertThat(palindrome).isEqualTo(99);
        assertThat(esPalindromeNumber(palindrome)).isTrue();

        palindrome = palindromeNumberPar.next();
        assertThat(palindrome).isNull();
    }

    @Test
    void should_return_1001_as_first_palindrome_number_par_with_4_digits() {
        PalindromeNumberPar palindromeNumberPar = new PalindromeNumberPar(4);
        Integer palindrome = palindromeNumberPar.next();

        assertThat(palindrome).isEqualTo(1001);
        assertThat(esPalindromeNumber(palindrome)).isTrue();
    }

    private boolean esPalindromeNumber(long number) {
        String numberString = Long.toString(number);
        return esPalindrome(numberString, 0, numberString.length() - 1);
    }

    private boolean esPalindrome(String number, int init, int end) {
        if(init > end){
            return true;
        }
        if(number.charAt(init) != number.charAt(end)){
            return false;
        }
        return esPalindrome(number, init + 1, end - 1);
    }
}