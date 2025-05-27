
package drll.problems.hacker_rank.array_manipulation;

import common.Utils;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class ArrayManipulationTest {

    @Test
    void should_return_correctly_for_test_case1() {
        long maxValue = ArrayManipulation.arrayManipulation(10,
                new int[][]{
                        {1, 5, 3},
                        {4, 8, 7},
                        {6, 9, 1}
                });

        assertThat(maxValue).isEqualTo(10);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        long maxValue = ArrayManipulation.arrayManipulation(5,
                new int[][]{
                        {1, 2, 100},
                        {2, 5, 100},
                        {3, 4, 100}
                });

        assertThat(maxValue).isEqualTo(200);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        long maxValue = ArrayManipulation.arrayManipulation(9,
                new int[][]{
                        {1, 2, 2},
                        {2, 5, 10},
                        {1, 6, 12},
                        {2, 7, 7},
                        {5, 7, 2},
                        {5, 8, 40}
                });

        assertThat(maxValue).isEqualTo(71);
    }

    @Test
    void should_return_correctly_for_test_case4() {
        long maxValue = ArrayManipulation.arrayManipulation(9,
                new int[][]{
                        {1, 2, 2},
                        {2, 5, 10},
                        {1, 6, 12},
                        {2, 7, 7},
                        {5, 7, 2}
                });

        assertThat(maxValue).isEqualTo(31);
    }

    @Test
    void should_return_correctly_for_test_case5() {
        long maxValue = ArrayManipulation.arrayManipulation(9,
                new int[][]{
                        {1, 2, 2},
                        {2, 5, 10},
                        {1, 6, 12},
                        {2, 7, 7},
                        {5, 7, 2},
                        {3, 4, 100}
                });

        assertThat(maxValue).isEqualTo(129);
    }

    @Test
    void should_return_correctly_for_test_case6() {
        long maxValue = ArrayManipulation.arrayManipulation(9,
                new int[][]{
                        {1, 2, 2},
                        {2, 5, 10},
                        {1, 6, 12},
                        {2, 7, 7},
                        {5, 7, 2},
                        {3, 4, 100},
                        {2, 9, 45}
                });

        assertThat(maxValue).isEqualTo(174);
    }

    @Test
    void should_return_correctly_for_test_case7() {
        long maxValue = ArrayManipulation.arrayManipulation(9,
                new int[][]{
                        {1, 2, 2},
                        {3, 4, 2},
                        {2, 5, 2},
                        {2, 3, 20}
                });

        assertThat(maxValue).isEqualTo(24);
    }

    @Test
    void should_return_correctly_for_test_case8() {
        long maxValue = ArrayManipulation.arrayManipulation(9,
                new int[][]{
                        {1, 3, 6},
                        {5, 7, 2},
                        {2, 9, 2}
                });

        assertThat(maxValue).isEqualTo(8);
    }

    @Test
    void should_return_correctly_for_test_case9() {
        long maxValue = ArrayManipulation.arrayManipulation(200,
                new int[][]{
                        {8, 15, 862970},
                        {17, 25, 838460},
                        {16, 28, 707452},
                        {4, 29, 550279},
                        {26, 32, 554316},
                        {24, 35, 709273},
                        {14, 44, 348693},
                        {16, 49, 945481},
                        {8, 50, 328481},
                        {12, 69, 576372},
                        {8, 71, 199390},
                        {17, 71, 747368},
                        {14, 74, 325643},
                        {48, 79, 541389},
                        {27, 86, 424300},
                        {36, 88, 990681},
                        {18, 90, 796739},
                        {72, 90, 825645}
                       // {21, 91, 942640}
                       // {14, 93, 972737} //19
                });

        assertThat(maxValue).isEqualTo(7213787);
    }

    @Test
    void should_return_correctly_for_test_case10() {
        long maxValue = ArrayManipulation.arrayManipulation(22,
                new int[][]{
                        {4, 5, 3},
                        {1, 16, 7},
                        {15, 20, 4},
                        {18, 22, 8}
                });

        assertThat(maxValue).isEqualTo(12);
    }

    @Test
    void should_return_correctly_for_test_case10_1() {
        long maxValue = ArrayManipulation.arrayManipulation(23,
                new int[][]{
                        {4, 5, 3},
                        {1, 16, 7},
                        {15, 20, 4},
                        {18, 22, 8}
                });

        assertThat(maxValue).isEqualTo(12);
    }

    @Test
    void should_return_correctly_for_test_case11() {

        long maxValue = ArrayManipulation.arrayManipulation(4,
                new int[][]{
                        {2, 3, 2},
                        {1, 1, 1},
                        {4, 4, 3}
                });

        assertThat(maxValue).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case11_1() {

        long maxValue = ArrayManipulation.arrayManipulation(5,
                new int[][]{
                        {2, 3, 2},
                        {1, 1, 1},
                        {4, 4, 3}
                });

        assertThat(maxValue).isEqualTo(3);
    }

    @Test
    void should_return_correctly_for_test_case12() {

        long maxValue = ArrayManipulation.arrayManipulation(10,
                new int[][]{
                        {1, 5, 3},
                        {4, 8, 7},
                        {6, 9, 1}
                });

        assertThat(maxValue).isEqualTo(10);
    }

    @Test
    void should_return_correctly_for_test_case13() {

        long maxValue = ArrayManipulation.arrayManipulation(10,
                new int[][]{
                        {1, 5, 3},
                        {4, 8, 7},
                        {6, 9, 1},
                        {6, 6, 3}
                });

        assertThat(maxValue).isEqualTo(11);
    }

    @Test
    void should_return_correctly_for_test_case14() {

        long maxValue = ArrayManipulation.arrayManipulation(10,
                new int[][]{
                        {1, 5, 3},
                        {4, 8, 7},
                        {6, 9, 1},
                        {5, 5, 3}
                });

        assertThat(maxValue).isEqualTo(13);
    }

    @Test
    void should_return_correctly_for_hr_test_case2() {

        String testDataFile = "arrayManipulation/testCase2.txt";

        long maxValue = ArrayManipulation.arrayManipulation(
                getArrayLengthFromTestCaseFile(testDataFile),
                buildQueriesInTestCaseFile(testDataFile));

        assertThat(maxValue).isEqualTo(8628);
    }

    @Test
    void should_return_correctly_for_hr_test_case3() {

        String testDataFile = "arrayManipulation/testCase3.txt";

        long maxValue = ArrayManipulation.arrayManipulation(
                getArrayLengthFromTestCaseFile(testDataFile),
                buildQueriesInTestCaseFile(testDataFile));

        assertThat(maxValue).isEqualTo(6314);
    }

    @Test
    void should_return_correctly_for_hr_test_case4() {

        String testDataFile = "arrayManipulation/testCase4.txt";

        long maxValue = ArrayManipulation.arrayManipulation(
                getArrayLengthFromTestCaseFile(testDataFile),
                buildQueriesInTestCaseFile(testDataFile));

        assertThat(maxValue).isEqualTo(7542539201L);
    }

    @Test
    void should_return_correctly_for_hr_test_case5() {

        String testDataFile = "arrayManipulation/testCase5.txt";

        long maxValue = ArrayManipulation.arrayManipulation(
                getArrayLengthFromTestCaseFile(testDataFile),
                buildQueriesInTestCaseFile(testDataFile));

        assertThat(maxValue).isEqualTo(7496167325L);
    }

    private int getArrayLengthFromTestCaseFile(String testDataFile) {

        Scanner sc = Utils.getFileScanner(testDataFile);

        return Integer.parseInt(sc.nextLine().split(" ")[0]);
    }

    private int[][] buildQueriesInTestCaseFile(String testDataFile) {

        Scanner sc = Utils.getFileScanner(testDataFile);

        String[] firstLine = sc.nextLine().split(" ");
        int[][] result = new int[Integer.parseInt(firstLine[1])][];

        int minWeight = Integer.MAX_VALUE;

        int i = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] query = line.split(" ");

            result[i] = new int[3];

            if(minWeight > Integer.parseInt(query[2])){
                minWeight = Integer.parseInt(query[2]);
            }

            result[i][0] = Integer.parseInt(query[0]);
            result[i][1] = Integer.parseInt(query[1]);
            result[i++][2] = Integer.parseInt(query[2]);
        }

        return result;
    }
}