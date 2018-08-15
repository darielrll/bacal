
package drll.problems.solveMeFirst;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.*;


@RunWith(MockitoJUnitRunner.class)
public class SolveMeFirstTest {

    @Test
    public void should_sum_two_numbers() {

        int a = 4;
        int b = 5;

        int result = SolveMeFirst.solveMeFirst(a,b);

        assertThat(result).isEqualTo(a + b);
    }
}