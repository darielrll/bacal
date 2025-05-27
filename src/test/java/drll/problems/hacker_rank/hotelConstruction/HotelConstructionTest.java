package drll.problems.hacker_rank.hotelConstruction;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HotelConstructionTest {
    @Test
    void should_order_hr_ex0(){
        List<List<Integer>> roads = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4),
                Arrays.asList(1, 5)
        );

        assertThat(Solution.numberOfWays(roads)).isEqualTo(4);
    }

    @Test
    void should_order_hr_ex1(){
        List<List<Integer>> roads = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 5),
                Arrays.asList(3, 4),
                Arrays.asList(4, 5),
                Arrays.asList(5, 6),
                Arrays.asList(7, 6)
        );

        assertThat(Solution.numberOfWays(roads)).isEqualTo(2);
    }

    @Test
    void should_order_hr_ex2(){
        List<List<Integer>> roads = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 5),
                Arrays.asList(3, 4),
                Arrays.asList(4, 5),
                Arrays.asList(5, 6),
                Arrays.asList(7, 6)
        );

        assertThat(Solution.numberOfWays(roads)).isEqualTo(2);
    }

    @Test
    void should_order_hr_ex3(){
        List<List<Integer>> roads = Arrays.asList(
                Arrays.asList(9, 5),
                Arrays.asList(12, 5),
                Arrays.asList(11, 9),
                Arrays.asList(13, 9),
                Arrays.asList(1, 12),
                Arrays.asList(8, 12),
                Arrays.asList(2, 11),
                Arrays.asList(3, 11),
                Arrays.asList(14, 13),
                Arrays.asList(4, 13),
                Arrays.asList(6, 1),
                Arrays.asList(7, 1),
                Arrays.asList(10, 8)
        );

        assertThat(Solution.numberOfWays(roads)).isEqualTo(39);
    }

    @Test
    void should_order_hr_ex4(){
        List<List<Integer>> roads = Arrays.asList(
                Arrays.asList(8, 19),
                Arrays.asList(7, 19),
                Arrays.asList(9, 8),
                Arrays.asList(15, 8),
                Arrays.asList(20, 7),
                Arrays.asList(23, 7),
                Arrays.asList(21, 9),
                Arrays.asList(14, 9),
                Arrays.asList(12, 15),
                Arrays.asList(16, 15),
                Arrays.asList(18, 20),
                Arrays.asList(17, 20),
                Arrays.asList(4, 23),
                Arrays.asList(10, 23),
                Arrays.asList(5, 21),
                Arrays.asList(22, 21),
                Arrays.asList(6, 14),
                Arrays.asList(2, 14),
                Arrays.asList(13, 12),
                Arrays.asList(11, 12),
                Arrays.asList(1, 16),
                Arrays.asList(3, 16)
        );

        assertThat(Solution.numberOfWays(roads)).isEqualTo(135);
    }

    @Test
    void should_order_hr_ex5(){
        List<List<Integer>> roads = Arrays.asList(
                Arrays.asList(13, 10),
                Arrays.asList(8, 10),
                Arrays.asList(22, 13),
                Arrays.asList(19, 13),
                Arrays.asList(16, 8),
                Arrays.asList(20, 8),
                Arrays.asList(5, 22),
                Arrays.asList(18, 22),
                Arrays.asList(9, 19),
                Arrays.asList(2, 19),
                Arrays.asList(21, 16),
                Arrays.asList(4, 16),
                Arrays.asList(17, 20),
                Arrays.asList(1, 20),
                Arrays.asList(11, 5),
                Arrays.asList(12, 5),
                Arrays.asList(6, 18),
                Arrays.asList(7, 18),
                Arrays.asList(23, 9),
                Arrays.asList(15, 9),
                Arrays.asList(3, 2),
                Arrays.asList(14, 2)
        );

        assertThat(Solution.numberOfWays(roads)).isEqualTo(135);
    }

    @Test
    void should_order_hr_ex6(){
        List<List<Integer>> roads = Arrays.asList(
                Arrays.asList(31, 12),
                Arrays.asList(26, 12),
                Arrays.asList(1, 12),
                Arrays.asList(29, 31),
                Arrays.asList(27, 31),
                Arrays.asList(16, 31),
                Arrays.asList(19, 26),
                Arrays.asList(5, 26),
                Arrays.asList(25, 26),
                Arrays.asList(3, 1),
                Arrays.asList(33, 1),
                Arrays.asList(30, 1),
                Arrays.asList(9, 29),
                Arrays.asList(14, 29),
                Arrays.asList(32, 29),
                Arrays.asList(35, 27),
                Arrays.asList(4, 27),
                Arrays.asList(24, 27),
                Arrays.asList(28, 16),
                Arrays.asList(21, 16),
                Arrays.asList(15, 16),
                Arrays.asList(23, 19),
                Arrays.asList(11, 19),
                Arrays.asList(22, 19),
                Arrays.asList(2, 5),
                Arrays.asList(6, 5),
                Arrays.asList(20, 5),
                Arrays.asList(7, 25),
                Arrays.asList(13, 25),
                Arrays.asList(10, 25),
                Arrays.asList(8, 3),
                Arrays.asList(34, 3),
                Arrays.asList(18, 3),
                Arrays.asList(17, 33)
        );

        assertThat(Solution.numberOfWays(roads)).isEqualTo(277);
    }
}