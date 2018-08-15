
package drll.problems.simpleArraySum;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class SimpleArraySumTest {

    @Test
    public void should_sum_all_numbers_in_array() {

        int[] numbers = {1,2,3,4};

        int result = SimpleArraySum.simpleArraySum(numbers);

        assertThat(result).isEqualTo(10);
    }
}