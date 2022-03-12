package drll.problems.leetcodeContest.problem2;

import common.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
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

    // 1000000000
}