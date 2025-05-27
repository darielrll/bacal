
package drll.problems.hacker_rank.k_factorization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PrimeIteratorTest {

    private PrimeIterator subject;

    @BeforeEach
    void init(){
        subject = new PrimeIterator();
    }

    @Test
    void should_return_current_first_prime() {
        assertThat(subject.currentPrimeNumber()).isEqualTo(2);
    }

    @Test
    void should_return_current_second_prime() {
        subject.nextPrimeNumber();
        assertThat(subject.currentPrimeNumber()).isEqualTo(3);
    }

    @Test
    void should_return_current_third_prime() {
        subject.nextPrimeNumber();
        subject.nextPrimeNumber();
        assertThat(subject.currentPrimeNumber()).isEqualTo(5);
    }

    @Test
    void should_return_current_fourth_prime() {
        subject.nextPrimeNumber();
        subject.nextPrimeNumber();
        subject.nextPrimeNumber();
        assertThat(subject.currentPrimeNumber()).isEqualTo(7);
    }

    @Test
    void should_return_current_8_prime() {
        //2, 3, 5, 7, 11, 13, 17, 19
        for (int i = 0; i < 7; i++) {
            subject.nextPrimeNumber();
        }
        assertThat(subject.currentPrimeNumber()).isEqualTo(19);
    }

    @Test
    void should_return_next_second_prime() {
        assertThat(subject.nextPrimeNumber()).isEqualTo(3);
    }

    @Test
    void should_return_next_third_prime() {
        subject.nextPrimeNumber();
        assertThat(subject.nextPrimeNumber()).isEqualTo(5);
    }

    @Test
    void should_return_next_fourth_prime() {
        subject.nextPrimeNumber();
        subject.nextPrimeNumber();
        assertThat(subject.nextPrimeNumber()).isEqualTo(7);
    }

    @Test
    void should_return_next_8_prime() {
        //2, 3, 5, 7, 11, 13, 17, 19
        for (int i = 0; i < 6; i++) {
            subject.nextPrimeNumber();
        }
        assertThat(subject.nextPrimeNumber()).isEqualTo(19);
    }

    @Test
    void reset() {
        for (int i = 0; i < 20; i++) {
            subject.nextPrimeNumber();
        }
        subject.reset();

        assertThat(subject.currentPrimeNumber()).isEqualTo(2);
    }

    @Test
    void isPrime_test_case1() {
        assertThat(subject.isPrime(2)).isTrue();
    }

    @Test
    void isPrime_test_case2() {
        assertThat(subject.isPrime(3)).isTrue();
    }

    @Test
    void isPrime_test_case3() {
        assertThat(subject.isPrime(5)).isTrue();
    }

    @Test
    void isPrime_test_case4() {
        assertThat(subject.isPrime(7)).isTrue();
    }

    @Test
    void isPrime_test_case5() {
        assertThat(subject.isPrime(11)).isTrue();
    }

    @Test
    void isPrime_test_case6() {
        assertThat(subject.isPrime(37)).isTrue();
    }

    @Test
    void not_isPrime_test_case1() {
        assertThat(subject.isPrime(4)).isFalse();
    }

    @Test
    void not_isPrime_test_case2() {
        assertThat(subject.isPrime(20)).isFalse();
    }

    @Test
    void not_isPrime_test_case3() {
        assertThat(subject.isPrime(35)).isFalse();
    }

    @Test
    void not_isPrime_test_case4() {
        assertThat(subject.isPrime(25)).isFalse();
    }

    @Test
    void not_isPrime_test_case5() {
        assertThat(subject.isPrime(100)).isFalse();
    }
}