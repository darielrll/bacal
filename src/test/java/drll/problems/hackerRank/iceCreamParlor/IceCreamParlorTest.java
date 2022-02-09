package drll.problems.hackerRank.iceCreamParlor;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IceCreamParlorTest {

    @Test
    public void shold_return_1_4(){
        List<Integer> result = IceCreamParlor.iceCreamParlor(4, Arrays.asList(1, 4, 5, 3, 2));

        assertThat(result).isEqualTo(Arrays.asList(1, 4));
    }

    @Test
    public void shold_return_1_2(){
        List<Integer> result = IceCreamParlor.iceCreamParlor(4, Arrays.asList(2, 2, 4, 3));

        assertThat(result).isEqualTo(Arrays.asList(1, 2));
    }

    @Test
    public void shold_return_2_4(){
        List<Integer> result = IceCreamParlor.iceCreamParlor(9, Arrays.asList(1, 3, 4, 6, 7, 9));

        assertThat(result).isEqualTo(Arrays.asList(2, 4));
    }

    @Test
    public void shold_return_3_4(){
        List<Integer> result = IceCreamParlor.iceCreamParlor(8, Arrays.asList(1, 3, 4, 4, 6, 8));

        assertThat(result).isEqualTo(Arrays.asList(3, 4));
    }

    @Test
    public void shold_return_1_2_second_case(){
        List<Integer> result = IceCreamParlor.iceCreamParlor(3, Arrays.asList(1, 2));


        assertThat(result).isEqualTo(Arrays.asList(1, 2));
    }
}