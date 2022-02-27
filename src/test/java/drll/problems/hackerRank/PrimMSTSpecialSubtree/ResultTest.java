package drll.problems.hackerRank.PrimMSTSpecialSubtree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static common.Utils.getFileScanner;
import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void should_return_correct_answer_for_test_case_1() {

        int nodeCount = 3;
        int[][] edges = new int[][]{{1, 2, 2}, {2, 3, 2}, {1, 3, 3}};
        int nodeStart = 1;

        assertThat(Result.prims(nodeCount, convertToList(edges), nodeStart)).isEqualTo(4);
    }

    @Test
    void should_return_correct_answer_for_test_case_2() {

        int nodeCount = 5;
        int[][] edges = new int[][]{{1, 2, 3}, {1, 3, 4}, {4, 2, 6}, {5, 2, 2}, {2, 3, 5}, {3, 5, 7}};
        int nodeStart = 1;

        assertThat(Result.prims(nodeCount, convertToList(edges), nodeStart)).isEqualTo(15);
    }

    @Test
    void should_return_correct_answer_for_test_case_5() {

        String testDataFile = "PrimMSTSpecialSubtree/testCase5.txt";
        int nodeCount = 1000;
        List<List<Integer>> edges = buildEdges(testDataFile);
        int nodeStart = 2;

        assertThat(Result.prims(nodeCount, edges, nodeStart)).isEqualTo(6359060);
    }

    private List<List<Integer>> buildEdges(String testDataFile) {
        List<List<Integer>> edges = new ArrayList<>();
        Scanner sc = getFileScanner(testDataFile);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineNumbers = line.split(" ");
            List<Integer> edge = new ArrayList<>();
            for (String lineNumber : lineNumbers) {
                edge.add(Integer.parseInt(lineNumber));
            }
            edges.add(edge);
        }
        return edges;
    }

    private List<List<Integer>> convertToList(int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for (int[] edge : edges) {
            List<Integer> edgeNormalized = new ArrayList<>();

            edgeNormalized.add(edge[0]);
            edgeNormalized.add(edge[1]);
            edgeNormalized.add(edge[2]);

            list.add(edgeNormalized);
        }

        return list;
    }
}