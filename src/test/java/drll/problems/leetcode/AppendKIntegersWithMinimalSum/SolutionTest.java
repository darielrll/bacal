package drll.problems.leetcode.AppendKIntegersWithMinimalSum;

import common.Utils;
import drll.problems.leetcode.AppendKIntegersWithMinimalSum.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @Test
    void should_return_correctly_for_test_case_custom() {
        assertThat(solution.minimalKSum(new int[]{1,4,25,10,25}, 100)).isEqualTo(5420);
    }

    @Test
    void should_return_correctly_for_test_case1() {
        assertThat(solution.minimalKSum(new int[]{1,4,25,10,25}, 2)).isEqualTo(5);
    }

    @Test
    void should_return_correctly_for_test_case2() {
        assertThat(solution.minimalKSum(new int[]{5,6}, 6)).isEqualTo(25);
    }

    @Test
    void should_return_correctly_for_test_case3() {
        int[] nums = new int[]{96,44,99,25,61,84,88,18,19,33,60,
                86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84};
        int k = 35;

        assertThat(solution.minimalKSum(nums, k)).isEqualTo(794);
    }

    @Test
    void should_return_correctly_for_test_case65() {
        int[] input = buildCaseFromFile("appendKIntegersWithMinimalSum/testCase65.txt");

        long minimalKSum = solution.minimalKSum(input, 1991601);

        assertThat(minimalKSum).isEqualTo(1983286874545L);
    }

    @Test
    void should_return_correctly_for_test_case72() {
        int[] input = buildCaseFromFile("appendKIntegersWithMinimalSum/testCase72.txt");

        long minimalKSum = solution.minimalKSum(input, 1000000000);

        assertThat(minimalKSum).isEqualTo(500099999500000000L);
    }

    private int[] buildCaseFromFile(String testDataFile) {

        Scanner sc = Utils.getFileScanner(testDataFile);

        String numbersLine = sc.nextLine();
        String[] numbersString = numbersLine.split(",");
        int[] numbers = new int[numbersString.length];

        for (int i = 0; i < numbersString.length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }

        return numbers;
    }
}