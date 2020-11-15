
package drll.problems.triangleNumbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.assertj.core.api.Assertions.*;

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

    @Test()
    @Timeout(value = 1)
    public void should_return_correctly_for_test_case5(){
        assertThat(TriangleNumbers.solve(4654564)).isEqualTo(3);
    }
}