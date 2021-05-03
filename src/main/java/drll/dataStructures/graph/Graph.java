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

    private int calculateEdgesCount(List<List<Integer>> edges) {
        int edgesCount = 0;
        for (List<Integer> adyacents : edges) {
            edgesCount += adyacents.size();
        }
        return edgesCount;
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
        edgesCount++;
        return true;
    }

    private boolean isNotValidEdge(int v1, int v2) {
        return v1 < 0 || v2 < 0 || v1 >= adjacencyList.size() || v2 >= adjacencyList.size();
    }

    public void addEdge(int[][] edges) {
        if(edges == null) {
            return;
        }
        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i][0], edges[i][1]);
        }
    }
}
