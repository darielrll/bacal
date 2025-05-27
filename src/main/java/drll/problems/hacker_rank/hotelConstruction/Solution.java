package drll.problems.hacker_rank.hotelConstruction;

import java.util.*;

public class Solution {
    // Complete the bigSorting function below.
    public static int numberOfWays(List<List<Integer>> roads) {
        HashMap<Integer, List<Integer>> graph = buildGraph(roads);

        int numberOfWays = 0;
        int totalCities = roads.size() + 1;
        for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            numberOfWays = Math.max(numberOfWays,
                    numberOfWaysCombinations(entry.getKey(), graph, totalCities));
        }

        return numberOfWays;
    }

    private static int numberOfWaysCombinations(Integer key, HashMap<Integer, List<Integer>> graph, int totalCities) {
        int numberOfWays = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(key);
        boolean[] visited = new boolean[totalCities + 1];
        while(!queue.isEmpty()){
            LinkedList<Integer> tmp = new LinkedList<>();
            while(!queue.isEmpty()){
                Integer city = queue.poll();
                if(!visited[city]){
                    visited[city] = true;
                    if(graph.containsKey(city)){
                        List<Integer> list = graph.get(city);
                        for (Integer neighbor : list){
                            if(!visited[neighbor]){
                                tmp.add(neighbor);
                            }
                        }
                    }
                }
            }
            if(tmp.size() >= 3){
                numberOfWays += numberOfWaysCombinations(tmp.size());
            }
            queue = tmp;
        }
        return numberOfWays;
    }

    private static HashMap<Integer, List<Integer>> buildGraph(List<List<Integer>> roads) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer> road : roads){
            int source = road.get(0);
            int target = road.get(1);
            addEdge(graph, source, target);
            addEdge(graph, target, source);
        }
        return graph;
    }

    private static void addEdge(HashMap<Integer, List<Integer>> graph, int source, int target){
        if(graph.containsKey(source)){
            List<Integer> list = graph.get(source);
            list.add(target);
            graph.replace(source, list);
        }
        else{
            List<Integer> list = new ArrayList<>();
            list.add(target);
            graph.put(source, list);
        }
    }

    private static int numberOfWaysCombinations(int citiesAtSameLevel) {
        if(citiesAtSameLevel == 3){
            return 1;
        }
        return factorial(citiesAtSameLevel)/(6 * factorial(citiesAtSameLevel - 3));
    }

    private static int factorial(int citiesAtSameLevel) {
        if(citiesAtSameLevel == 1){
            return 1;
        }
        return citiesAtSameLevel * factorial(citiesAtSameLevel - 1);
    }
}