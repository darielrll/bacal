package drll.problems.hackerRank.kittysCalculationsOnATree;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public static int[] calculateFormula(int[][] edges, int[][] queries){
        return new int[]{};
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstLine = bufferedReader.readLine().trim().split(" ");
        int nodesCount = Integer.parseInt(firstLine[0]);
        int querySetsCount = Integer.parseInt(firstLine[1]);

        int[][] edges = new int[nodesCount - 1][];
        for (int i = 0; i < nodesCount - 1; i++) {
            String[] edge = bufferedReader.readLine().trim().split(" ");
            int v = Integer.parseInt(edge[0]);
            int w = Integer.parseInt(edge[1]);

            edges[i] = new int[]{v, w};
        }
        int[][] queries = new int[querySetsCount][];
        for (int i = 0; i < querySetsCount; i++) {
            int setSize = Integer.parseInt(bufferedReader.readLine().trim());
            String[] set = bufferedReader.readLine().trim().split(" ");
            int[] setNodes = new int[setSize];
            for (int j = 0; j < setNodes.length; j++) {
                setNodes[j] = Integer.parseInt(set[j]);
            }
            queries[i] = setNodes;
        }

        int[] formulaCalculation = Solution.calculateFormula(edges, queries);

        for (int i = 0; i < formulaCalculation.length; i++) {
            bufferedWriter.write(String.valueOf(formulaCalculation[i]));
            bufferedWriter.newLine();
        }

        Arrays.stream(formulaCalculation).forEach(formula -> {
            try {
                bufferedWriter.write(String.valueOf(formula));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}