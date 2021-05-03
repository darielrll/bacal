package drll.dataStructures.graph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GraphTest {

    @Test
    public void should_have_5_vertex_when_graph_is_created_with_5_vertex(){
        Graph graph = new Graph(5);

        assertThat(graph.vertexCount()).isEqualTo(5);
    }

    @Test
    public void should_have_empty_edges_when_graph_is_created_with_5_vertex(){
        Graph graph = new Graph(5);

        assertThat(graph.edgeCount()).isEqualTo(0);
    }

    @Test
    public void should_have_one_edge_when_graph_is_created_with_one_edge(){
        int[][] edges = new int[][]{{0, 2}};
        Graph graph = new Graph(edges);

        assertThat(graph.edgeCount()).isEqualTo(1);
    }
}
