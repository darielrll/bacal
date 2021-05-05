package drll.dataStructures.graph;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.List;

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
        assertThat(graph.isAdjacent(2, 0)).isTrue();
    }

    @Test
    public void should_be_adjacent_v1_and_v2_when_graph_is_created_with_edge_1_and_2(){
        int[][] edges = new int[][]{{1, 2}};

        Graph graph = new Graph(edges);

        assertThat(graph.edgeCount()).isEqualTo(1);
        assertThat(graph.isAdjacent(1, 2)).isTrue();
        assertThat(graph.isAdjacent(2, 1)).isTrue();
    }

    @Test
    public void should_return_false_when_add_an_edge_that_already_exist(){
        int[][] edges = new int[][]{{1, 2}};
        Graph graph = new Graph(edges);

        assertThat(graph.addEdge(1, 2)).isFalse();
        assertThat(graph.addEdge(2, 1)).isFalse();
        assertThat(graph.edgeCount()).isEqualTo(1);
    }

    @Test
    public void should_return_true_when_add_a_new_edge(){
        int[][] edges = new int[][]{{1, 2}};
        Graph graph = new Graph(edges);

        assertThat(graph.addEdge(0, 2)).isTrue();
        assertThat(graph.isAdjacent(0, 2)).isTrue();
        assertThat(graph.isAdjacent(2, 0)).isTrue();
        assertThat(graph.edgeCount()).isEqualTo(2);
    }

    @Test
    public void should_add_a_list_of_edge(){
        int[][] edges = new int[][]{{1, 2}, {0, 2}, {0, 3}};
        Graph graph = new Graph(4);

        graph.addEdge(edges);

        assertThat(graph.isAdjacent(1, 2)).isTrue();
        assertThat(graph.isAdjacent(2, 1)).isTrue();
        assertThat(graph.isAdjacent(0, 2)).isTrue();
        assertThat(graph.isAdjacent(2, 0)).isTrue();
        assertThat(graph.isAdjacent(0, 3)).isTrue();
        assertThat(graph.isAdjacent(3, 0)).isTrue();
        assertThat(graph.edgeCount()).isEqualTo(3);
    }

    @Test
    public void should_not_add_a_null_list_of_edges(){
        Graph graph = new Graph(4);

        graph.addEdge(null);

        assertThat(graph.edgeCount()).isEqualTo(0);
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

    @Test
    public void should_have_vertex_2_degree_3(){
        int[][] edges = new int[][]{{1, 2}, {0, 2}, {2, 3}};
        Graph graph = new Graph(edges);

        assertThat(graph.vertexDegree(2)).isEqualTo(3);
    }

    @Test
    public void should_throw_exception_when_is_request_vertex_degree_for_an_invalid_vertex(){
        int[][] edges = new int[][]{{1, 2}, {0, 2}, {2, 3}};
        Graph graph = new Graph(edges);

        InvalidParameterException exception = assertThrows(InvalidParameterException.class, () -> graph.vertexDegree(7));
        assertThat("Vertex indexes should be >= 0 and <= 3").isEqualTo(exception.getMessage());
    }

    @Test
    public void should_have_three_adjacent_vertex(){
        int[][] edges = new int[][]{{1, 2}, {0, 2}, {2, 3}};
        Graph graph = new Graph(edges);

        List<Integer> adjacents = graph.adjacent(2);

        assertThat(adjacents.size()).isEqualTo(3);
        assertThat(adjacents.contains(1)).isTrue();
        assertThat(adjacents.contains(0)).isTrue();
        assertThat(adjacents.contains(3)).isTrue();
    }

    @Test
    public void should_throw_exception_when_is_request_adjacent_for_an_invalid_vertex(){
        int[][] edges = new int[][]{{1, 2}, {0, 2}, {2, 3}};
        Graph graph = new Graph(edges);

        InvalidParameterException exception = assertThrows(InvalidParameterException.class, () -> graph.adjacent(7));
        assertThat("Vertex indexes should be >= 0 and <= 3").isEqualTo(exception.getMessage());
    }
}
