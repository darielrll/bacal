package drll.dataStructures.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int vertext;
    private final List<Integer>[] edges;
    private int edgeCount;

    public Graph(int vertext) {
        this.vertext = vertext;
        edges = new ArrayList<Integer>[0];
    }

    private static int getMaxVertex() {
        return 0;
    }

    public int vertexCount() {
        return vertext;
    }

    public int edgeCount() {
        return edges.length;
    }
}
