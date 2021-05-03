package drll.dataStructures.graph;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThat(graph.isAdjacent(0, 2)).isTrue();
    }

    @Test
    public void should_be_adjacent_v1_and_v2_when_graph_is_created_with_edge_1_and_2(){
        int[][] edges = new int[][]{{1, 2}};
        Graph graph = new Graph(edges);

        assertThat(graph.isAdjacent(1, 2)).isTrue();
    }

    @Test
    public void should_return_false_when_add_an_edge_that_already_exist(){
        int[][] edges = new int[][]{{1, 2}};
        Graph graph = new Graph(edges);

        assertThat(graph.addEdge(1, 2)).isFalse();
    }

    @Test
    public void should_return_true_when_add_a_new_edge(){
        int[][] edges = new int[][]{{1, 2}};
        Graph graph = new Graph(edges);

        assertThat(graph.addEdge(0, 2)).isTrue();
        assertThat(graph.isAdjacent(0, 2)).isTrue();
    }

    @Test
    public void should_return_add_a_list_of_edge(){
        int[][] edges = new int[][]{{1, 2}, {0, 2}, {0, 3}};
        Graph graph = new Graph(4);

        graph.addEdge(edges);

        assertThat(graph.edgeCount()).isEqualTo(3);
    }

    @Test
    public void should_throw_exception_adding_edge_when_vertex_are_negative(){
        int[][] edges = new int[][]{{1, 2}};
        Graph graph = new Graph(edges);

        InvalidParameterException exception = assertThrows(InvalidParameterException.class, () -> graph.addEdge(-1, -3));
        assertThat("Vertex indexes should be >= 0 and <= 2").isEqualTo(exception.getMessage());
    }

    @Test
    public void should_throw_exception_adding_edge_when_vertex_are_greater_than_allowed(){
        Graph graph = new Graph(2);

        InvalidParameterException exception = assertThrows(InvalidParameterException.class, () -> graph.addEdge(2, 6));
        assertThat("Vertex indexes should be >= 0 and <= 1").isEqualTo(exception.getMessage());
    }
}
