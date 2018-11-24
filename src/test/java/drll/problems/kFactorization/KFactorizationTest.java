
package drll.problems.kFactorization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class KFactorizationTest {

    @Test
    public void should_return_correctly_for_test_case1() {

        int[] small = KFactorization.kFactorization(12, new int[]{2, 3, 4});

        assertThat(small).isEqualTo(new int[]{1, 3, 12});
    }

    @Test
    public void should_return_correctly_for_test_case2() {

        int[] small = KFactorization.kFactorization(15, new int[]{2, 10, 6, 9, 11});

        assertThat(small).isEqualTo(new int[]{-1});
    }

    @Test
    public void should_return_correctly_for_test_case3() {

        int[] small = KFactorization.kFactorization(12, new int[]{2, 6});

        assertThat(small).isEqualTo(new int[]{1, 2, 12});
    }

    @Test
    public void should_return_correctly_for_test_case4() {

        int[] small = KFactorization.kFactorization(72, new int[]{2, 4, 6, 9, 3, 7, 16, 10, 5});

        assertThat(small).isEqualTo(new int[]{1, 2, 8, 72});
    }

    @Test
    public void should_return_correctly_for_hr_test_case4() {

        int[] small = KFactorization.kFactorization(964518043, new int[]{4});

        assertThat(small).isEqualTo(new int[]{-1});
    }

    @Test
    public void should_return_correctly_for_hr_test_case5() {

        int[] small = KFactorization.kFactorization(175840877, new int[]{4, 5, 6, 7, 8, 10, 12, 17, 18, 19});

        assertThat(small).isEqualTo(new int[]{-1});
    }

    @Test
    public void should_return_correctly_for_hr_test_case6() {

        int[] small = KFactorization.kFactorization(49584742, new int[]{2, 3, 5, 6, 8, 9, 11, 12, 13, 14, 16, 19, 20});

        assertThat(small).isEqualTo(new int[]{-1});
    }

    @Test
    public void should_return_correctly_for_hr_test_case7() {

        int[] small = KFactorization.kFactorization(231000000, new int[]{2, 3, 5, 7, 11, 13, 17, 19});

        assertThat(small).isEqualTo(new int[]{1, 2, 4, 8, 16, 32, 64, 192, 960, 4800, 24000, 120000, 600000, 3000000, 21000000, 231000000});
    }

    @Test
    public void should_find_number_test_case1(){
        int[] list = new int[]{1,2,3,4};
        assertThat(KFactorization.findNumber(list, 2)).isEqualTo(1);
    }

    @Test
    public void should_find_number_test_case2(){
        int[] list = new int[]{1,2,3,4};
        assertThat(KFactorization.findNumber(list, 1)).isEqualTo(0);
    }

    @Test
    public void should_find_number_test_case3(){
        int[] list = new int[]{1,2,3,4};
        assertThat(KFactorization.findNumber(list, 4)).isEqualTo(3);
    }

    @Test
    public void should_find_number_test_case4(){
        int[] list = new int[]{1,2,3,4,5};
        assertThat(KFactorization.findNumber(list, 1)).isEqualTo(0);
    }

    @Test
    public void should_find_number_test_case5(){
        int[] list = new int[]{1,2,3,4,5};
        assertThat(KFactorization.findNumber(list, 5)).isEqualTo(4);
    }

    @Test
    public void should_not_find_number_test_case1(){
        int[] list = new int[]{1,2,3,4};
        assertThat(KFactorization.findNumber(list, -2)).isEqualTo(-1);
    }

    @Test
    public void should_not_find_number_test_case2(){
        int[] list = new int[]{1,2,3,4};
        assertThat(KFactorization.findNumber(list, 5)).isEqualTo(-1);
    }

    @Test
    public void should_not_find_number_test_case3(){
        int[] list = new int[]{1,2,3,4,5};
        assertThat(KFactorization.findNumber(list, -1)).isEqualTo(-1);
    }

    @Test
    public void should_not_find_number_test_case4(){
        int[] list = new int[]{1,2,3,4,5};
        assertThat(KFactorization.findNumber(list, 6)).isEqualTo(-1);
    }
}