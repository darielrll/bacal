package drll.problems.hackerRank.kittysCalculationsOnATree;

import java.io.*;
import java.util.*;

public class Solution {

    public static int[] calculateFormula(int nodesCount, int[][] edges, int[][] queries) {
        int[][] pathCosts = allPairsShortestPathFloydWarshall(nodesCount, edges);

        final int queriesLength = queries.length;
        final int congruence = (int) (Math.pow(10, 9) + 7);
        final int[] formulaResults = new int[queriesLength];

        for (int i = 0; i < queriesLength; i++) {
            int[] query = queries[i];
            int queryLength = query.length;

            int formulaResult = 0;
            for (int u = 0; u < queryLength - 1; u++) {
                for (int v = u + 1; v < queryLength; v++) {
                    int vertexU = query[u] % congruence;
                    int vertexV = query[v] % congruence;
                    formulaResult += (vertexU % congruence) * (vertexV % congruence) * (pathCosts[vertexU][vertexV] % congruence);
                    formulaResult %= congruence;
                }
            }
            formulaResults[i] = formulaResult;
        }
        return formulaResults;
    }

    private static int[][] allPairsShortestPathFloydWarshall(int nodesCount, int[][] edges) {
        int[][] pathCosts = new int[edges.length + 2][edges.length + 2];

        for (int[] edge : edges) {
            pathCosts[edge[0]][edge[1]] = 1;
            pathCosts[edge[1]][edge[0]] = 1;
        }

        for (int k = 1; k <= nodesCount; k++) {
            for (int i = 1, length = pathCosts.length; i < length; i++) {
                for (int j = 1; j < length; j++) {
                    if(i == j){
                        continue;
                    }
                    if (pathCosts[i][j] == 0){
                        pathCosts[i][j] = nodesCount;
                    }
                    pathCosts[i][j] = Math.min(pathCosts[i][j], pathCosts[i][k] + pathCosts[k][j]);
                }
            }
        }

        return pathCosts;
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

        int[] formulaCalculation = Solution.calculateFormula(nodesCount, edges, queries);

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