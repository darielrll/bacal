
package drll.problems.hacker_rank.solveMeFirst;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class SolveMeFirstTest {

    @Test
    void should_sum_two_numbers() {

        int a = 4;
        int b = 5;

        int result = SolveMeFirst.solveMeFirst(a,b);

        assertThat(result).isEqualTo(a + b);
    }
}