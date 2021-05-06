package drll.dataStructures.graph;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Graph{
    private final List<List<Integer>> adjacencyList;
    private int edgesCount;

    public Graph(int vertex) {
        adjacencyList = initAdjacencyList(vertex - 1);
        edgesCount = 0;
    }

    public Graph(int[][] edges) {
        int lastVertex = calculateVertexCount(edges);
        adjacencyList = initAdjacencyList(lastVertex);
        addEdge(edges);
    }

    public int vertexCount() {
        return adjacencyList.size();
    }

    public int edgeCount() {
        return edgesCount;
    }

    public boolean isAdjacent(int v1, int v2) {
        return adjacencyList.get(v1).contains(v2);
    }

    public boolean addEdge(int v1, int v2) {
        if(isNotValidEdge(v1, v2)){
            riseException();
        }
        if(isAdjacent(v1, v2)){
            return false;
        }
        adjacencyList.get(v1).add(v2);
        if(v1 != v2){
            adjacencyList.get(v2).add(v1);
        }
        edgesCount++;
        return true;
    }

    public void addEdge(int[][] edges) {
        if(edges == null) {
            return;
        }
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }
    }

    public boolean removeEdge(int v1, int v2) {
        if(isNotValidEdge(v1, v2)){
            riseException();
        }
        if(isAdjacent(v1, v2)){
            adjacencyList.get(v1).remove(Integer.valueOf(v2));
            if(v1 != v2){
                adjacencyList.get(v2).remove(Integer.valueOf(v1));
            }
            edgesCount--;
            return true;
        }
        return false;
    }

    public List<Integer> adjacent(int vertex) {
        if(isNotValidVertex(vertex)){
            riseException();
        }
        return adjacencyList.get(vertex);
    }

    public int vertexDegree(int vertex) {
        if(isNotValidVertex(vertex)){
            riseException();
        }
        return adjacencyList.get(vertex).size();
    }

    public Iterable<Integer> vertex() {
        return () -> IntStream.range(0, adjacencyList.size()).iterator();
    }


    private boolean isNotValidEdge(int v1, int v2) {
        return isNotValidVertex(v1)  ||  isNotValidVertex(v2);
    }

    private boolean isNotValidVertex(int vertex) {
        return vertex < 0 || vertex >= adjacencyList.size();
    }

    private List<List<Integer>> initAdjacencyList(int vertex) {
        List<List<Integer>> edgeList = new ArrayList<>(vertex);
        for (int i = 0; i <= vertex; i++) {
            edgeList.add(new ArrayList<>());
        }
        return edgeList;
    }

    private int calculateVertexCount(int[][] edges) {
        int lastVertex = 0;
        for (int[] edge : edges) {
            for (int i : edge) {
                if (lastVertex < i) {
                    lastVertex = i;
                }
            }
        }
        return lastVertex;
    }

    private void riseException() {
        throw new InvalidParameterException(String.format("Vertex indexes should be >= 0 and <= %s",
                adjacencyList.size() - 1));
    }
}
