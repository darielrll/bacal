
package drll.problems.hackerRank.commonChild;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CommonChildTest {

    @Test
    void should_work_for_hr_ex_test_case1(){
        int result = CommonChild.commonChild("ABCD",
                                             "ABDC");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void should_work_for_hr_ex_test_case2(){

        int result = CommonChild.commonChild("HARRY",
                                             "SALLY");

        assertThat(result).isEqualTo(2);
    }

    @Test
    void should_work_for_hr_ex_test_case3(){
        int result = CommonChild.commonChild("AA",
                                             "BB");

        assertThat(result).isEqualTo(0);
    }

    @Test
    void should_work_for_hr_ex_test_case4(){
        int result = CommonChild.commonChild("SHINCHAN", "NOHARAAA");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void should_work_for_hr_ex_test_case5(){
        int result = CommonChild.commonChild("ABCDEF",
                "FBDAMN");

        assertThat(result).isEqualTo(2);
    }

    @Test
    void should_work_for_hr_test_case1(){
        int result = CommonChild.commonChild("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS",
                                            "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC");

        assertThat(result).isEqualTo(15);
    }
}