
package drll.problems.hacker_rank.missingNumbers;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MissingNumbersTest {

    @Test
    void should_response_correctly_for_test_case1(){
        int[] original = new int[]{7, 2, 5, 4, 6, 3, 5, 3},
                missing = new int[]{7, 2, 5, 3, 5, 3};

        int[] missingNumbers = MissingNumbers.missingNumbers(missing, original);

        assertThat(missingNumbers).isEqualTo(new int[]{4, 6});
    }

    @Test
    void should_response_correctly_for_test_case2(){
        int[] original = new int[]{203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204},
                missing = new int[]{203, 204, 205, 206, 207, 208, 203, 204, 205, 206};

        int[] missingNumbers = MissingNumbers.missingNumbers(missing, original);

        assertThat(missingNumbers).isEqualTo(new int[]{204, 205, 206});
    }
}