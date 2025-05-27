package drll.problems.hacker_rank.insertion_sort_part1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InsertionSortPart1Test {
    @Test
    void should_print_a_number_list_to_string() {
        List<Integer> numbers = createNumbersList(1, 2, 4, 5, 5);

        assertThat(InsertionSortPart1.print(numbers)).isEqualTo("1 2 4 5 5");
    }

    @Test
    void should_print_same_list_when_is_ordered() {
        List<Integer> numbers = createNumbersList(1, 2, 4, 5, 6);

        assertThat(InsertionSortPart1.insertionMovements(numbers)).isEqualTo("1 2 4 5 6");
    }

    @Test
    void should_print_two_insertion_sort_movements() {
        List<Integer> numbers = createNumbersList(1, 2, 4, 6, 5);

        assertThat(InsertionSortPart1.insertionMovements(numbers)).isEqualTo("1 2 4 6 6\n1 2 4 5 6");
    }

    @Test
    void should_print_four_insertion_sort_movements() {
        List<Integer> numbers = createNumbersList(2, 4, 6, 8, 3);

        assertThat(InsertionSortPart1.insertionMovements(numbers)).isEqualTo(
                "2 4 6 8 8\n2 4 6 6 8\n2 4 4 6 8\n2 3 4 6 8");
    }

    @Test
    void should_work_for_test_case1() {
        List<Integer> numbers = createNumbersList(2, 3, 4, 5, 6, 7, 8, 9, 10, 1);

        assertThat(InsertionSortPart1.insertionMovements(numbers)).isEqualTo(
                "2 3 4 5 6 7 8 9 10 10\n" +
                "2 3 4 5 6 7 8 9 9 10\n" +
                "2 3 4 5 6 7 8 8 9 10\n" +
                "2 3 4 5 6 7 7 8 9 10\n" +
                "2 3 4 5 6 6 7 8 9 10\n" +
                "2 3 4 5 5 6 7 8 9 10\n" +
                "2 3 4 4 5 6 7 8 9 10\n" +
                "2 3 3 4 5 6 7 8 9 10\n" +
                "2 2 3 4 5 6 7 8 9 10\n" +
                "1 2 3 4 5 6 7 8 9 10");
    }

    @Test
    void should_work_for_test_case2() {
        List<Integer> numbers = createNumbersList(2, 3, 1);

        assertThat(InsertionSortPart1.insertionMovements(numbers)).isEqualTo(
                "2 3 3\n" +
                "2 2 3\n" +
                "1 2 3");
    }

    private List<Integer> createNumbersList(int ... numbers) {
        List<Integer> numbersList = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            numbersList.add(numbers[i]);
        }

        return numbersList;
    }
}