package drll.dataStructures.graph;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final List<List<Integer>> adjacencyList;
    private int edgesCount;

    public Graph(int vertex) {
        adjacencyList = initAdjacencyList(vertex - 1);
        edgesCount = 0;
    }

    public Graph(int[][] edges) {
        int lastVertex = calculateVertexCount(edges);
        this.adjacencyList = initAdjacencyList(lastVertex);
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
            throw new InvalidParameterException(String.format("Vertex indexes should be >= 0 and <= %s",
                    adjacencyList.size() - 1));
        }
        if(isAdjacent(v1, v2)){
            return false;
        }
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
        edgesCount++;
        return true;
    }

    public void addEdge(int[][] edges) {
        if(edges == null) {
            return;
        }
        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i][0], edges[i][1]);
        }
    }

    public List<Integer> adjacent(int vertex) {
        if(isNotValidVertex(vertex)){
            throw new InvalidParameterException(String.format("Vertex indexes should be >= 0 and <= %s",
                    adjacencyList.size() - 1));
        }
        return adjacencyList.get(vertex);
    }

    public int vertexDegree(int vertex) {
        if(isNotValidVertex(vertex)){
            throw new InvalidParameterException(String.format("Vertex indexes should be >= 0 and <= %s",
                    adjacencyList.size() - 1));
        }
        return adjacencyList.get(vertex).size();
    }

    private boolean isNotValidEdge(int v1, int v2) {
        return isNotValidVertex(v1)  ||  isNotValidVertex(v2);
    }

    private boolean isNotValidVertex(int vertex) {
        return vertex < 0 || vertex >= adjacencyList.size();
    }

    private List<List<Integer>> initAdjacencyList(int vertex) {
        List<List<Integer>> adjacencyList = new ArrayList<>(vertex);
        for (int i = 0; i <= vertex; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        return adjacencyList;
    }

    private int calculateVertexCount(int[][] edges) {
        int lastVertex = 0;
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                if(lastVertex < edges[i][j]){
                    lastVertex = edges[i][j];
                }
            }
        }
        return lastVertex;
    }
}
