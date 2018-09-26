
package drll.problems.bonetrousle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class BonetrousleTest {

    @Test
    public void should_respond_correctly_for_test_case_1() {
        Long[] bonetrousle = Bonetrousle.bonetrousle(12, 8, 3);

        Set<Long> result = new HashSet<>();
        long boughtStick = 0;
        for (int i = 0; i < bonetrousle.length; i++) {
            assertThat(result.add(bonetrousle[i])).isTrue();
            assertThat(bonetrousle[i]).isGreaterThan(0);
            boughtStick += bonetrousle[i];
        }
        assertThat(boughtStick).isEqualTo(12);
    }

    @Test
    public void should_respond_correctly_for_test_case_2() {
        Long[] bonetrousle = Bonetrousle.bonetrousle(4, 4, 2);

        Set<Long> result = new HashSet<>();
        long boughtStick = 0;
        for (int i = 0; i < bonetrousle.length; i++) {
            assertThat(result.add(bonetrousle[i])).isTrue();
            assertThat(bonetrousle[i]).isGreaterThan(0);
            boughtStick += bonetrousle[i];
        }
        assertThat(boughtStick).isEqualTo(4);
    }

    @Test
    public void should_respond_correctly_for_test_case_3() {
        Long[] bonetrousle = Bonetrousle.bonetrousle(10, 3, 3);

        assertThat(bonetrousle.length).isEqualTo(0);
    }

    @Test
    public void should_respond_correctly_for_test_case_4() {
        Long[] bonetrousle = Bonetrousle.bonetrousle(9, 10, 2);

        Set<Long> result = new HashSet<>();
        long boughtStick = 0;
        for (int i = 0; i < bonetrousle.length; i++) {
            assertThat(result.add(bonetrousle[i])).isTrue();
            assertThat(bonetrousle[i]).isGreaterThan(0);
            boughtStick += bonetrousle[i];
        }
        assertThat(boughtStick).isEqualTo(9);
    }

    @Test
    public void should_respond_correctly_for_test_case_5() {
        Long[] bonetrousle = Bonetrousle.bonetrousle(22, 7, 6);
        // falla porque hay valores con 0
        Set<Long> result = new HashSet<>();
        long boughtStick = 0;
        for (int i = 0; i < bonetrousle.length; i++) {
            assertThat(result.add(bonetrousle[i])).isTrue();
            assertThat(bonetrousle[i]).isGreaterThan(0);
            boughtStick += bonetrousle[i];
        }
        assertThat(boughtStick).isEqualTo(22);
    }

    @Test
    public void should_respond_correctly_for_test_case_6() {
        Long[] bonetrousle = Bonetrousle.bonetrousle(26, 7, 6);
        // falla porque se repiten valores
        Set<Long> result = new HashSet<>();
        long boughtStick = 0;
        for (int i = 0; i < bonetrousle.length; i++) {
            assertThat(result.add(bonetrousle[i])).isTrue();
            assertThat(bonetrousle[i]).isGreaterThan(0);
            boughtStick += bonetrousle[i];
        }
        assertThat(boughtStick).isEqualTo(26);
    }

    @Test
    public void should_respond_correctly_for_test_case_7() {
        Long[] bonetrousle = Bonetrousle.bonetrousle(25, 10, 5);
        // falla porque hay valores con 0
        Set<Long> result = new HashSet<>();
        long boughtStick = 0;
        for (int i = 0; i < bonetrousle.length; i++) {
            assertThat(result.add(bonetrousle[i])).isTrue();
            assertThat(bonetrousle[i]).isGreaterThan(0);
            boughtStick += bonetrousle[i];
        }
        assertThat(boughtStick).isEqualTo(25);
    }

    @Test
    public void should_respond_correctly_for_test_case_8() {
        Long[] bonetrousle = Bonetrousle.bonetrousle(39, 15, 3);
        // falla porque hay valores con 0
        Set<Long> result = new HashSet<>();
        long boughtStick = 0;
        for (int i = 0; i < bonetrousle.length; i++) {
            assertThat(result.add(bonetrousle[i])).isTrue();
            assertThat(bonetrousle[i]).isGreaterThan(0);
            boughtStick += bonetrousle[i];
        }
        assertThat(boughtStick).isEqualTo(39);
    }

    @Test
    public void should_respond_correctly_for_test_case_9() {
        Long[] bonetrousle = Bonetrousle.bonetrousle(95, 20, 10);
        // falla porque hay valores con 0 y se repiten los 0
        Set<Long> result = new HashSet<>();
        long boughtStick = 0;
        for (int i = 0; i < bonetrousle.length; i++) {
            assertThat(result.add(bonetrousle[i])).isTrue();
            assertThat(bonetrousle[i]).isGreaterThan(0);
            boughtStick += bonetrousle[i];
        }
        assertThat(boughtStick).isEqualTo(95);
    }
}