package drll.dataStructures.graph;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GraphTest {

    @Test
    void should_have_5_vertex_when_graph_is_created_with_5_vertex(){
        Graph graph = new Graph(5);

        assertThat(graph.vertexCount()).isEqualTo(5);
    }

    @Test
    void should_have_empty_edges_when_graph_is_created_with_5_vertex(){
        Graph graph = new Graph(5);

        assertThat(graph.edgeCount()).isZero();
    }

    @Test
    void should_have_one_edge_when_graph_is_created_with_one_edge(){
        int[][] edges = new int[][]{{0, 2}};

        Graph graph = new Graph(edges);

        assertThat(graph.edgeCount()).isEqualTo(1);
        assertThat(graph.isAdjacent(0, 2)).isTrue();
        assertThat(graph.isAdjacent(2, 0)).isTrue();
    }

    @Test
    void should_be_adjacent_v1_and_v2_when_graph_is_created_with_edge_1_and_2(){
        int[][] edges = new int[][]{{1, 2}};

        Graph graph = new Graph(edges);

        assertThat(graph.edgeCount()).isEqualTo(1);
        assertThat(graph.isAdjacent(1, 2)).isTrue();
        assertThat(graph.isAdjacent(2, 1)).isTrue();
    }

    @Test
    void should_return_false_when_add_an_edge_that_already_exist(){
        int[][] edges = new int[][]{{1, 2}};
        Graph graph = new Graph(edges);

        assertThat(graph.addEdge(1, 2)).isFalse();
        assertThat(graph.addEdge(2, 1)).isFalse();
        assertThat(graph.edgeCount()).isEqualTo(1);
    }

    @Test
    void should_return_true_when_add_a_new_edge(){
        int[][] edges = new int[][]{{1, 2}};
        Graph graph = new Graph(edges);

        assertThat(graph.addEdge(0, 2)).isTrue();
        assertThat(graph.isAdjacent(0, 2)).isTrue();
        assertThat(graph.isAdjacent(2, 0)).isTrue();
        assertThat(graph.edgeCount()).isEqualTo(2);
    }

    @Test
    void should_return_vertex_degree_equal_1_for_an_edge_to_the_same_vertex(){
        Graph graph = new Graph(1);

        assertThat(graph.addEdge(0, 0)).isTrue();
        assertThat(graph.vertexDegree(0)).isEqualTo(1);
    }

    @Test
    void should_add_a_list_of_edge(){
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
    void should_not_add_a_null_list_of_edges(){
        Graph graph = new Graph(4);

        graph.addEdge(null);

        assertThat(graph.edgeCount()).isZero();
    }

    @Test
    void should_throw_exception_adding_edge_when_vertex_are_negative(){
        int[][] edges = new int[][]{{1, 2}};
        Graph graph = new Graph(edges);

        InvalidParameterException exception = assertThrows(InvalidParameterException.class, () -> graph.addEdge(-1, -3));
        assertThat(exception.getMessage()).isEqualTo("Vertex indexes should be >= 0 and <= 2");
    }

    @Test
    void should_throw_exception_adding_edge_when_vertex_are_greater_than_allowed(){
        Graph graph = new Graph(2);

        InvalidParameterException exception = assertThrows(InvalidParameterException.class, () -> graph.addEdge(2, 6));
        assertThat(exception.getMessage()).isEqualTo("Vertex indexes should be >= 0 and <= 1");
    }

    @Test
    void should_return_true_when_remove_an_existing_edge(){
        int[][] edges = new int[][]{{1, 2}, {0, 2}, {0, 3}};
        Graph graph = new Graph(edges);

        assertThat(graph.removeEdge(1, 2)).isTrue();
        assertThat(graph.edgeCount()).isEqualTo(2);
        assertThat(graph.isAdjacent(1, 2)).isFalse();
        assertThat(graph.isAdjacent(2, 1)).isFalse();
    }

    @Test
    void should_return_false_when_remove_a_non_existing_edge(){
        int[][] edges = new int[][]{{1, 2}, {0, 2}, {0, 3}};
        Graph graph = new Graph(edges);

        assertThat(graph.removeEdge(2, 3)).isFalse();
        assertThat(graph.edgeCount()).isEqualTo(3);
    }

    @Test
    void should_return_true_when_remove_an_existing_edge_to_the_same_vertex(){
        Graph graph = new Graph(1);
        assertThat(graph.addEdge(0, 0)).isTrue();

        assertThat(graph.removeEdge(0, 0)).isTrue();
        assertThat(graph.edgeCount()).isZero();
        assertThat(graph.vertexDegree(0)).isZero();
    }

    @Test
    void should_throw_exception_removing_an_edge_when_vertex_are_negative(){
        int[][] edges = new int[][]{{1, 2}};
        Graph graph = new Graph(edges);

        InvalidParameterException exception = assertThrows(InvalidParameterException.class, () -> graph.removeEdge(-1, -3));
        assertThat(exception.getMessage()).isEqualTo("Vertex indexes should be >= 0 and <= 2");
    }

    @Test
    void should_throw_exception_removing_an_edge_when_vertex_are_greater_than_allowed(){
        Graph graph = new Graph(2);

        InvalidParameterException exception = assertThrows(InvalidParameterException.class, () -> graph.addEdge(2, 6));
        assertThat(exception.getMessage()).isEqualTo("Vertex indexes should be >= 0 and <= 1");
    }

    @Test
    void should_have_vertex_2_degree_3(){
        int[][] edges = new int[][]{{1, 2}, {0, 2}, {2, 3}};
        Graph graph = new Graph(edges);

        assertThat(graph.vertexDegree(2)).isEqualTo(3);
    }

    @Test
    void should_throw_exception_when_is_request_vertex_degree_for_an_invalid_vertex(){
        int[][] edges = new int[][]{{1, 2}, {0, 2}, {2, 3}};
        Graph graph = new Graph(edges);

        InvalidParameterException exception = assertThrows(InvalidParameterException.class, () -> graph.vertexDegree(7));
        assertThat(exception.getMessage()).isEqualTo("Vertex indexes should be >= 0 and <= 3");
    }

    @Test
    void should_have_three_adjacent_vertex(){
        int[][] edges = new int[][]{{1, 2}, {0, 2}, {2, 3}};
        Graph graph = new Graph(edges);

        List<Integer> adjacents = graph.adjacent(2);

        assertThat(adjacents.size()).isEqualTo(3);
        assertThat(adjacents.contains(1)).isTrue();
        assertThat(adjacents.contains(0)).isTrue();
        assertThat(adjacents.contains(3)).isTrue();
    }

    @Test
    void should_throw_exception_when_is_request_adjacent_for_an_invalid_vertex(){
        int[][] edges = new int[][]{{1, 2}, {0, 2}, {2, 3}};
        Graph graph = new Graph(edges);

        InvalidParameterException exception = assertThrows(InvalidParameterException.class, () -> graph.adjacent(7));
        assertThat(exception.getMessage()).isEqualTo("Vertex indexes should be >= 0 and <= 3");
    }

    @Test
    void should_iterate_over_all_vertex(){
        int[][] edges = new int[][]{{1, 2}, {0, 2}, {2, 3}};
        Graph graph = new Graph(edges);

        List<Integer> vertexGraph = new ArrayList<>();
        for (Integer vertex : graph.vertex()) {
            vertexGraph.add(vertex);
        }

        assertThat(vertexGraph.size()).isEqualTo(4);
        assertThat(vertexGraph.contains(0)).isTrue();
        assertThat(vertexGraph.contains(1)).isTrue();
        assertThat(vertexGraph.contains(2)).isTrue();
        assertThat(vertexGraph.contains(3)).isTrue();
    }

    @Test
    void should_return_vertex_count_when_is_added_a_vertex_and_count_increment_in_one(){
        int vertexCount = 5;
        Graph graph = new Graph(vertexCount);

        assertThat(graph.addVertex()).isEqualTo(vertexCount);
        assertThat(graph.vertexCount()).isEqualTo(vertexCount + 1);
    }

//    @Test
//    void should_return_true_when_a_valid_vertex_is_removed(){
//        int vertexCount = 5;
//        Graph graph = new Graph(vertexCount);
//
//        assertThat(graph.removeVertex()).isEqualTo(vertexCount);
//        assertThat(graph.vertexCount()).isEqualTo(vertexCount + 1);
//    }
}
