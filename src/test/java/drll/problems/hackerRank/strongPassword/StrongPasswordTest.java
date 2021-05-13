
package drll.problems.hackerRank.strongPassword;

import org.junit.jupiter.api.Test;
import static drivero.problems.strongPassword.StrongPassword.*;
import static org.assertj.core.api.Assertions.*;

class StrongPasswordTest {

    @Test
    void should_add_3_characters(){
        int result = minimumNumber(3, "Ab1");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void should_add_1_characters(){
        int result = minimumNumber(11, "#HackerRank");

        assertThat(result).isEqualTo(1);
    }

    @Test
    void should_add_5_characters(){
        int result = minimumNumber(1, "9");

        assertThat(result).isEqualTo(5);
    }
}