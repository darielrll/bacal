package drll.problems.leetcodeContest.Problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {
    private Problem2 problem2;

    @BeforeEach
    void init(){
        problem2 = new Problem2();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(problem2.minimumOperations(new int[]{3,1,3,2,4,3})).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(problem2.minimumOperations(new int[]{1,2,2,2,2})).isEqualTo(2);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        assertThat(problem2.minimumOperations(new int[]{69,91,47,74,75,94,22,100,
                43,50,82,47,40,51,90,27,98,85,47,14,55,82,52,9,65,90,86,45,52,52,
                95,40,85,3,46,77,16,59,32,22,41,87,89,78,59,78,34,26,71,9,82,68,
                80,74,100,6,10,53,84,80,7,87,3,82,26,26,14,37,26,58,96,73,41,2,
                79,43,56,74,30,71,6,100,72,93,83,40,28,79,24})).isEqualTo(84);
    }
}