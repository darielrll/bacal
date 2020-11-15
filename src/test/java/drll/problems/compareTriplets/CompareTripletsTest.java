
package drll.problems.compareTriplets;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CompareTripletsTest {

    @Test
    public void should_work_for_test_case1(){
        int[] result = CompareTriplets.solve(new int[]{5, 6, 7},
                                            new int[]{3, 6, 10});

        assertThat(result).isEqualTo(new int[]{1, 1});
    }

    @Test
    public void should_work_for_test_case2(){
        int[] result = CompareTriplets.solve(new int[]{17, 28, 30},
                                            new int[]{99, 16, 8});

        assertThat(result).isEqualTo(new int[]{2, 1});
    }
}