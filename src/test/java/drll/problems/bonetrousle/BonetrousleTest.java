
package drll.problems.bonetrousle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class BonetrousleTest {

    @Test
    public void should_respond_correctly_for_test_case_1() {
        long[] bonetrousle = Bonetrousle.bonetrousle(12, 8, 3);

        assertThat(bonetrousle).isEqualTo(new long[]{2, 3, 7});
    }

    @Test
    public void should_respond_correctly_for_test_case_2() {
        long[] bonetrousle = Bonetrousle.bonetrousle(10, 3, 3);

        assertThat(bonetrousle).isEqualTo(new long[]{-1});
    }

    @Test
    public void should_respond_correctly_for_test_case_3() {
        long[] bonetrousle = Bonetrousle.bonetrousle(9, 10, 2);

        assertThat(bonetrousle).isEqualTo(new long[]{5, 4});
    }

    @Test
    public void should_respond_correctly_for_test_case_4() {
        long[] bonetrousle = Bonetrousle.bonetrousle(9, 10, 2);

        assertThat(bonetrousle).isEqualTo(new long[]{1, 8});
    }
}