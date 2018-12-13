
package drll.problems.hackerlandRadioTransmitters;

import common.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class HackerlandRadioTransmittersTest {

    @Test
    public void should_respond_correctly_for_test_case1(){
        int antennae = HackerlandRadioTransmitters.hackerlandRadioTransmitters(new int[]{1, 2, 3, 5, 9}, 1);
        assertThat(antennae).isEqualTo(3);
    }

    @Test
    public void should_respond_correctly_for_test_case2(){
        int antennae = HackerlandRadioTransmitters.hackerlandRadioTransmitters(new int[]{1, 2, 3, 4, 5, 9}, 1);
        assertThat(antennae).isEqualTo(3);
    }

    @Test
    public void should_respond_correctly_for_test_case3(){
        int antennae = HackerlandRadioTransmitters.hackerlandRadioTransmitters(new int[]{1, 2, 3, 4, 5}, 1);
        assertThat(antennae).isEqualTo(2);
    }

    @Test
    public void should_respond_correctly_for_test_case4(){
        int antennae = HackerlandRadioTransmitters.hackerlandRadioTransmitters(new int[]{7, 2, 4, 6, 5, 9, 12, 11}, 2);
        assertThat(antennae).isEqualTo(3);
    }

    @Test
    public void should_respond_correctly_for_test_case5(){
        int antennae = HackerlandRadioTransmitters.hackerlandRadioTransmitters(new int[]{1, 2, 3, 4, 6, 7, 11, 12,
                                                                                        14, 17, 18, 21, 25, 28, 32,
                                                                                        35, 37, 38, 41, 43, 44, 46,
                                                                                        47, 48}, 6);
        assertThat(antennae).isEqualTo(5);
    }

    @Test
    public void should_respond_correctly_for_hr_test_case3(){
        int antennae = HackerlandRadioTransmitters.hackerlandRadioTransmitters(new int[]{9, 5, 4, 2, 6, 15, 12}, 2);
        assertThat(antennae).isEqualTo(4);
    }

    @Test
    public void should_respond_correctly_for_hr_test_case6(){
        String testDataFile = "hackerlandRadioTransmitters/testCase5.txt";

        int antennae = HackerlandRadioTransmitters.hackerlandRadioTransmitters(Utils.buildArrayIntFromFile(testDataFile), 80);

        assertThat(antennae).isEqualTo(620);
    }

    @Test
    public void should_respond_correctly_for_hr_test_case12(){
        String testDataFile = "hackerlandRadioTransmitters/testCase12.txt";

        int antennae = HackerlandRadioTransmitters.hackerlandRadioTransmitters(Utils.buildArrayIntFromFile(testDataFile), 6);

        assertThat(antennae).isEqualTo(7684);
    }
}