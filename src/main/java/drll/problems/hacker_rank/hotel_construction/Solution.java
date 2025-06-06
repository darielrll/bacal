package drll.problems.hacker_rank.hotel_construction;

import java.util.*;

public class Solution {

    private Solution() {
        throw new IllegalStateException("Utility class");
    }
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
            List<Integer> nextLevel = collectUnvisitedNeighbors(graph, queue, visited);
            if(nextLevel.size() >= 3){
                numberOfWays += numberOfWaysCombinations(nextLevel.size());
            }
            queue.addAll(nextLevel);
        }
        return numberOfWays;
    }

    private static List<Integer> collectUnvisitedNeighbors(HashMap<Integer, List<Integer>> graph, Queue<Integer> queue, boolean[] visited) {
        List<Integer> nextLevel = new LinkedList<>();
        while(!queue.isEmpty()){
            Integer city = queue.poll();
            if(!visited[city]){
                visited[city] = true;
                if(graph.containsKey(city)){
                    List<Integer> list = graph.get(city);
                    for (Integer neighbor : list){
                        if(!visited[neighbor]){
                            nextLevel.add(neighbor);
                        }
                    }
                }
            }
        }
        return nextLevel;
    }

    private static HashMap<Integer, List<Integer>> buildGraph(List<List<Integer>> roads) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer> road : roads){
            int fromCity = road.get(0);
            int toCity = road.get(1);
            addEdge(graph, fromCity, toCity);
            addEdge(graph, toCity, fromCity);
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