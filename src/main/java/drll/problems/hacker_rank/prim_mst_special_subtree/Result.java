
package drll.problems.hacker_rank.prim_mst_special_subtree;

import java.util.*;

public class Result {

    public static int prims(int n, List<List<Integer>> edges, int start) {
        int[] costs = initCosts(n + 1);
        boolean[] visited = new boolean[n + 1];
        List<Integer> mst = new ArrayList<>();
        HashMap<Integer, List<List<Integer>>> graph = buildGraph(edges);

        costs[start] = 0;
        visited[start] = true;
        mst.add(start);

        while (mst.size() != n) {

            int destination = 0;
            int destinationWeight = Integer.MAX_VALUE;

            /*
            * iterate over all nodes already in MST to find
            * the node not in MST with minimum weight that
            * is adjacent to a node in MST
            * */
            for (int v : mst) {

                List<Integer> adjacent = graph.get(v).get(0);
                List<Integer> weights = graph.get(v).get(1);

                for (int j = 0, adjacentCount = adjacent.size(); j < adjacentCount; j++) {
                    Integer w = adjacent.get(j);
                    if (visited[w]) {
                        continue;
                    }
                    Integer wWeight = weights.get(j);

                    updateCostsW(costs, w, wWeight);

                    if (wWeight < destinationWeight) {
                        destinationWeight = wWeight;
                        destination = w;
                    }
                }
            }

            mst.add(destination);
            visited[destination] = true;
        }

        return Arrays.stream(costs).sum();
    }

    private static void updateCostsW(int[] costs, Integer w, Integer wWeight) {
        if (wWeight < costs[w]) {
            costs[w] = wWeight;
        }
    }

    private static int[] initCosts(int n) {
        int[] costs = new int[n];
        Arrays.fill(costs, 1, costs.length, (int) (Math.pow(10, 5) + 1));
        return costs;
    }

    private static HashMap<Integer, List<List<Integer>>> buildGraph(List<List<Integer>> edges) {
        HashMap<Integer, List<List<Integer>>> graph = new HashMap<>();

        for (List<Integer> edge : edges) {
            int v = edge.get(0);
            int w = edge.get(1);
            int weight = edge.get(2);

            addEdge(graph, v, w, weight);
            addEdge(graph, w, v, weight);
        }

        return graph;
    }

    private static void addEdge(HashMap<Integer, List<List<Integer>>> graph, int v, int w, int weight) {
        if (graph.containsKey(v)) {
            graph.get(v).get(0).add(w);
            graph.get(v).get(1).add(weight);
        } else {
            List<Integer> adjacent = new ArrayList<>();
            adjacent.add(w);
            List<Integer> weights = new ArrayList<>();
            weights.add(weight);

            List<List<Integer>> neighbors = new ArrayList<>();
            neighbors.add(adjacent);
            neighbors.add(weights);

            graph.put(v, neighbors);
        }
    }
}