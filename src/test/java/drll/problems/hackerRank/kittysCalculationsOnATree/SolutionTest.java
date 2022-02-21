package drll.problems.hackerRank.kittysCalculationsOnATree;

import common.Utils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void should_return_correctly_for_test_case1() {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}, {3, 7}};
        int[][] queries = new int[][]{{4, 5, 7}};

        int[] small = Solution.calculateFormula(7, edges, queries);

        assertThat(small).isEqualTo(new int[]{214});
    }

    @Test
    public void should_return_correctly_for_test_case2() {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}, {3, 7}};
        int[][] queries = new int[][]{{2, 4}, {5}, {2, 4, 5}};

        int[] small = Solution.calculateFormula(7, edges, queries);

        assertThat(small).isEqualTo(new int[]{16, 0, 106});
    }

    @Test
    public void should_return_correctly_for_test_case3() {
        String testCasePath = "kittysCalculationsOnATree/testCase1.txt";
        String testCaseResult = "kittysCalculationsOnATree/testCase1-results.txt";
        TestCase testCase = buildCaseFromFile(testCasePath);
        int[] expectedResults = buildCaseResultFromFile(testCaseResult, testCase.queries.length);

        int[] currentResults = Solution.calculateFormula(testCase.nodesCount, testCase.edges, testCase.queries);

        assertThat(currentResults).isEqualTo(expectedResults);
    }

    @Test
    public void should_return_correctly_for_test_case7() {
        String testCasePath = "kittysCalculationsOnATree/testCase7.txt";
        String testCaseResult = "kittysCalculationsOnATree/testCase7-results.txt";
        TestCase testCase = buildCaseFromFile(testCasePath);
        int[] expectedResults = buildCaseResultFromFile(testCaseResult, testCase.queries.length);

        int[] currentResults = Solution.calculateFormula(testCase.nodesCount, testCase.edges, testCase.queries);

        assertThat(currentResults).isEqualTo(expectedResults);
    }

    private TestCase buildCaseFromFile(String testDataFile) {
        Scanner sc = Utils.getFileScanner(testDataFile);

        String[] firstLine = sc.nextLine().trim().split(" ");
        int nodesCount = Integer.parseInt(firstLine[0]);
        int querySetsCount = Integer.parseInt(firstLine[1]);

        int[][] edges = new int[nodesCount - 1][];
        for (int i = 0; i < nodesCount - 1; i++) {
            String[] edge = sc.nextLine().trim().split(" ");
            int v = Integer.parseInt(edge[0]);
            int w = Integer.parseInt(edge[1]);

            edges[i] = new int[]{v, w};
        }
        int[][] queries = new int[querySetsCount][];
        for (int i = 0; i < querySetsCount; i++) {
            int setSize = Integer.parseInt(sc.nextLine().trim());
            String[] set = sc.nextLine().trim().split(" ");
            int[] setNodes = new int[setSize];
            for (int j = 0; j < setNodes.length; j++) {
                setNodes[j] = Integer.parseInt(set[j]);
            }
            queries[i] = setNodes;
        }

        int[][][] testCase = new int[2][][];
        testCase[0] = edges;
        testCase[1] = queries;

        return new TestCase(edges, queries, nodesCount);
    }

    private int[] buildCaseResultFromFile(String resultDataFile, int querySetsCount) {
        Scanner sc = Utils.getFileScanner(resultDataFile);
        int[] results = new int[querySetsCount];

        int i = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            results[i++] = Integer.parseInt(line);
        }

        return results;
    }

    class TestCase{
        public int[][] edges, queries;
        public int nodesCount;

        public TestCase(int[][] edges, int[][] queries, int nodesCount) {
            this.edges = edges;
            this.queries = queries;
            this.nodesCount = nodesCount;
        }
    }
}