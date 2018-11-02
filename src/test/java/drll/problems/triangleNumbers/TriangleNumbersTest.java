
package drll.problems.triangleNumbers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class TriangleNumbersTest {

    @Test
    public void should_return_correctly_for_test_case1(){
        assertThat(TriangleNumbers.solve(3)).isEqualTo(2);
    }

    @Test
    public void should_return_correctly_for_test_case2(){
        assertThat(TriangleNumbers.solve(4)).isEqualTo(3);
    }

    @Test
    public void should_return_correctly_for_test_case3(){
        assertThat(TriangleNumbers.solve(1)).isEqualTo(-1);
    }

    @Test
    public void should_return_correctly_for_test_case4(){
        assertThat(TriangleNumbers.solve(2)).isEqualTo(-1);
    }

    @Test(timeout = 1000)
    public void should_return_correctly_for_test_case5(){
        assertThat(TriangleNumbers.solve(4654564)).isEqualTo(3);
    }
}