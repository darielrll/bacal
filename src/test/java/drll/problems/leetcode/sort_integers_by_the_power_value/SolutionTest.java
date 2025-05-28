package drll.problems.leetcode.sort_integers_by_the_power_value;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(solution.getKth(12, 15, 2)).isEqualTo(13);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.getKth(7, 11, 4)).isEqualTo(7);
    }

    @Test
    void should_return_power_7_when_number_is_3() {
        Hashtable<Integer, Integer> history = new Hashtable<>();

        assertThat(solution.getPowerValue(3, history)).isEqualTo(7);
        assertThat(history.size()).isEqualTo(7);
        assertThat(history.get(3)).isEqualTo(7);
    }

    @Test
    void should_return_power_9_when_number_is_12() {
        Hashtable<Integer, Integer> history = new Hashtable<>();

        assertThat(solution.getPowerValue(12, history)).isEqualTo(9);
        assertThat(history.size()).isEqualTo(9);
        assertThat(history.get(12)).isEqualTo(9);
    }

    @Test
    void should_return_power_9_when_number_is_13() {
        Hashtable<Integer, Integer> history = new Hashtable<>();

        assertThat(solution.getPowerValue(13, history)).isEqualTo(9);
        assertThat(history.size()).isEqualTo(9);
        assertThat(history.get(13)).isEqualTo(9);
    }

    @Test
    void should_return_power_17_when_number_is_14() {
        Hashtable<Integer, Integer> history = new Hashtable<>();

        assertThat(solution.getPowerValue(14, history)).isEqualTo(17);
        assertThat(history.size()).isEqualTo(17);
        assertThat(history.get(14)).isEqualTo(17);
    }

    @Test
    void should_return_power_17_when_number_is_15() {
        Hashtable<Integer, Integer> history = new Hashtable<>();

        assertThat(solution.getPowerValue(15, history)).isEqualTo(17);
        assertThat(history.size()).isEqualTo(17);
        assertThat(history.get(15)).isEqualTo(17);
    }

    @Test
    void should_return_power_1_when_number_is_2() {
        Hashtable<Integer, Integer> history = new Hashtable<>();

        assertThat(solution.getPowerValue(2, history)).isEqualTo(1);
        assertThat(history.size()).isEqualTo(1);
        assertThat(history.get(2)).isEqualTo(1);
    }
}