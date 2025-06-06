
package drll.problems.hacker_rank.big_sorting;

import common.Utils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class BigSortingTest {

    @Test
    void should_order_hr_ex1(){
        String[] input = new String[]{"6",
        "31415926535897932384626433832795",
        "1", "3", "10", "3", "5"};

        String[] result = Solution.bigSorting(input);

        assertThat(result).isEqualTo(new String[]{"1",
                "3",
                "3",
                "5",
                "6",
                "10",
                "31415926535897932384626433832795"});
    }

    @Test
    void should_order_hr_ex2(){
        String[] input = new String[]{"8",
                                      "1",
                                      "2",
                                      "100",
                                      "12303479849857341718340192371",
                                      "3084193741082937",
                                      "3084193741082938",
                                      "111",
                                      "200"};

        String[] result = Solution.bigSorting(input);

        assertThat(result).isEqualTo(new String[]{"1",
                                                  "2",
                                                  "8",
                                                  "100",
                                                  "111",
                                                  "200",
                                                  "3084193741082937",
                                                  "3084193741082938",
                                                  "12303479849857341718340192371"});
    }

    @Test
    void should_order_hr_testCase6(){
        String[] input = buildCaseFromFile("bigSorting/testCase6.txt");
        String[] expected = buildCaseFromFile("bigSorting/testCase6_result.txt");

        String[] result = Solution.bigSorting(input);

        assertThat(result.length).isEqualTo(expected.length);
        for (int i = 0; i < result.length; i++) {
            if( result[i].compareTo(expected[i]) != 0 ){
                assertThat(true).isFalse();
            }
        }
        assertThat(true).isTrue();
    }

    private String[] buildCaseFromFile(String testDataFile) {

        Scanner sc = Utils.getFileScanner(testDataFile);

        List<String> numbers = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            numbers.add(line);
        }

        return numbers.toArray(new String[0]);
    }
}