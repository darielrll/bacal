package drll.problems.leetcode.find_palindrome_with_fixed_length;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_1_as_first_palindrome_of_length_1() {
        assertThat(solution.getFirstPalindromeOfLength(1))
                .isEqualTo("1");
    }

    @Test
    void should_11_as_first_palindrome_of_length_2() {
        assertThat(solution.getFirstPalindromeOfLength(2))
                .isEqualTo("11");
    }

    @Test
    void should_101_as_first_palindrome_of_length_3() {
        assertThat(solution.getFirstPalindromeOfLength(3))
                .isEqualTo("101");
    }

    @Test
    void should_1001_as_first_palindrome_of_length_4() {
        assertThat(solution.getFirstPalindromeOfLength(4))
                .isEqualTo("1001");
    }

    @Test
    void should_return_2_when_palindrome_is_1() {
        assertThat(solution.getNextPalindrome("1"))
                .isEqualTo("2");
    }

    @Test
    void should_return_6_when_palindrome_is_5() {
        assertThat(solution.getNextPalindrome("5"))
                .isEqualTo("6");
    }

    @Test
    void should_return_11_when_palindrome_is_9() {
        assertThat(solution.getNextPalindrome("9"))
                .isEqualTo("11");
    }

    @Test
    void should_return_101_when_palindrome_is_99() {
        assertThat(solution.getNextPalindrome("99"))
                .isEqualTo("101");
    }

    @Test
    void should_return_10001_when_palindrome_is_9999() {
        assertThat(solution.getNextPalindrome("9999"))
                .isEqualTo("10001");
    }

    @Test
    void should_return_2002_when_palindrome_is_1991() {
        assertThat(solution.getNextPalindrome("1991"))
                .isEqualTo("2002");
    }

    @Test
    void should_return_9999_when_palindrome_is_8998() {
        assertThat(solution.getNextPalindrome("8998"))
                .isEqualTo("9009");
    }

    @Test
    void should_return_22_when_palindrome_is_11() {
        assertThat(solution.getNextPalindrome("11"))
                .isEqualTo("22");
    }

    @Test
    void should_return_111_when_palindrome_is_101() {
        assertThat(solution.getNextPalindrome("101"))
                .isEqualTo("111");
    }

    @Test
    void should_return_202_when_palindrome_is_101() {
        assertThat(solution.getNextPalindrome("191"))
                .isEqualTo("202");
    }

    @Test
    void should_return_999_when_palindrome_is_1001() {
        assertThat(solution.getNextPalindrome("999"))
                .isEqualTo("1001");
    }

    @Test
    void should_return_898_when_palindrome_is_999() {
        assertThat(solution.getNextPalindrome("898"))
                .isEqualTo("909");
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(solution.kthPalindrome(new int[]{1,2,3,4,5,90}, 3))
                .isEqualTo(new long[]{101,111,121,131,141,999});
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.kthPalindrome(new int[]{2,4,6}, 4))
                .isEqualTo(new long[]{1111,1331,1551});
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(solution.kthPalindrome(new int[]{2,201429812,8,520498110,492711727,339882032,462074369,9,7,6}, 1))
                .isEqualTo(new long[]{2L, -1L, 8L, -1L, -1L, -1L, -1L, 9L, 7L, 6L});
    }

    @Test
    void should_return_correctly_for_test_case3_1() {
        assertThat(solution.kthPalindrome(new int[]{2,8,9,7,6}, 1))
                .isEqualTo(new long[]{2L, 8L, 9L, 7L, 6L});
    }

    @Test
    void should_return_correctly_for_test_case4() {
        assertThat(solution.kthPalindrome(new int[]{6,910748851,2,2,471967776,568041505,706056676,28558130,8,6,9,9,3,8}, 1))
                .isEqualTo(new long[]{6,-1,2,2,-1,-1,-1,-1,8,6,9,9,3,8});
    }

    @Test
    void should_return_correctly_for_test_case5() {
        assertThat(solution.kthPalindrome(new int[]{696771750,62,47,14,17,192356691,209793716,23,220935614,447911113,5,4,72}, 4))
                .isEqualTo(new long[]{-1,7117,5665,2332,2662,-1,-1,3223,-1,-1,1441,1331,8118});
    }

    @Test
    void should_return_correctly_for_test_case5_1() {
        assertThat(solution.kthPalindrome(new int[]{4, 5, 14, 17, 23, 47, 62, 72}, 4))
                .isEqualTo(new long[]{1331,1441,2332,2662,3223,5665,7117,8118});
    }

    @Test
    void should_return_correctly_for_test_case5_2() {
        assertThat(solution.kthPalindrome(new int[]{23, 47, 62, 72}, 4))
                .isEqualTo(new long[]{3223,5665,7117,8118});
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void should_return_correctly_for_test_case6() {
        assertThat(solution.kthPalindrome(new int[]{683392906,677531155,81,635486904,396454130,178964399}, 13))
                .isEqualTo(new long[]{-1,-1,1000080800001L,-1,-1,-1});
    }

    @Test
    void should_return_correctly_for_test_case6_1() {
        assertThat(solution.kthPalindrome(new int[]{81}, 13))
                .isEqualTo(new long[]{1000080800001L});
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    void should_return_correctly_for_test_case7() {
        assertThat(solution.kthPalindrome(new int[]{572521748,377073593,2,43160372,987707952,6,391690915,56,85}, 13))
                .isEqualTo(new long[]{-1,-1,1000001000001L,-1,-1,1000005000001L,-1,1000055500001L,1000084800001L});
    }

    @Test
    void should_return_correctly_for_test_case135() {
        assertThat(solution.kthPalindrome(new int[]{90,70,56,283715139,3,31,85,19,38,513196622,420306840,8,248263976,574957528}, 3))
                .isEqualTo(new long[]{999,797,656,-1,121,404,949,282,474,-1,-1,171,-1,-1});
    }

    @Test
    void should_return_correctly_for_test_case135_1() {
        assertThat(solution.kthPalindrome(new int[]{90,70,56,3,31,85,19,38,8}, 3))
                .isEqualTo(new long[]{999,797,656,121,404,949,282,474,171});
    }

    @Test
    //me quede aqui resolviendo este test que es consecuencia de los dos anteriores
    void should_return_correctly_for_test_case135_2() {
        assertThat(solution.kthPalindrome(new int[]{90,85}, 3))
                .isEqualTo(new long[]{999,949});
    }
}