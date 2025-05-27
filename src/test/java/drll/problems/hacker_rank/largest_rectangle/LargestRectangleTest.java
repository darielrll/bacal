
package drll.problems.hacker_rank.largest_rectangle;

import common.Utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.assertj.core.api.Assertions.*;

class LargestRectangleTest {

    @Test
    void should_work_for_test_case_1(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{3, 2, 3});
        assertThat(largestRectangle).isEqualTo(6);
    }

    @Test
    void should_work_for_test_case_2(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{1, 2, 3, 4, 5});
        assertThat(largestRectangle).isEqualTo(9);
    }

    @Test
    void should_work_for_test_case_3(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{1, 2, 3, 4, 5, 3, 3, 2});
        assertThat(largestRectangle).isEqualTo(15);
    }

    @Test
    void should_work_for_test_case_4(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{1, 2, 3, 4, 5, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3});
        assertThat(largestRectangle).isEqualTo(21);
    }

    @Test
    void should_work_for_test_case_5(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{11, 11, 10, 10, 10});
        assertThat(largestRectangle).isEqualTo(50);
    }

    @Test
    void should_work_for_test_case_6(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{5, 4, 3, 2, 1});
        assertThat(largestRectangle).isEqualTo(9);
    }

    @Test
    void should_work_for_test_case_7(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{2, 2, 2, 2, 2});
        assertThat(largestRectangle).isEqualTo(10);
    }

    @Test
    void should_work_for_test_case_8(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{2, 12});
        assertThat(largestRectangle).isEqualTo(12);
    }

    @Test
    void should_work_for_test_case_9(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{2, 1, 2});
        assertThat(largestRectangle).isEqualTo(3);
    }

    @Test
    void should_work_for_test_case_10(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{5,5,5,5,1,1,1,1});
        assertThat(largestRectangle).isEqualTo(20);
    }

    @Test
    void should_work_for_test_case_11(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{7, 2, 1, 4, 5, 1, 3, 3});
        assertThat(largestRectangle).isEqualTo(8);
    }

    @Test
    void should_work_for_test_case_12(){
        long largestRectangle = LargestRectangle.largestRectangle(new int[]{4, 1000, 1000, 1000, 1000});
        assertThat(largestRectangle).isEqualTo(4000);
    }

    @Test()
    @Timeout(value = 3)
    void should_work_for_test_case_13(){
        String testDataFile = "largestRectangle/testCase8.txt";

        long largestRectangle = LargestRectangle.largestRectangle(Utils.buildArrayIntFromFile(testDataFile));

        assertThat(largestRectangle).isEqualTo(12984467);
    }
}