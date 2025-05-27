
package drll.problems.hacker_rank.simpleArraySum;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class SimpleArraySumTest {

    @Test
    void should_sum_all_numbers_in_array() {

        int[] numbers = {1,2,3,4};

        int result = SimpleArraySum.simpleArraySum(numbers);

        assertThat(result).isEqualTo(10);
    }
}