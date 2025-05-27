package drll.problems.hacker_rank.connected_cells_in_a_grid;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConnectedCellsInAGridTest {

    @Test
    void should_return_largest_area_is_3(){
        List<List<Integer>> matrix = buildMatrix( new int[][]{
                {1, 1, 0},
                {1, 0, 0},
                {0, 0, 1}
        });

        assertThat(ConnectedCellsInAGrid.connectedCell(matrix)).isEqualTo(3);
    }

    @Test
    void should_return_largest_area_is_5(){
        List<List<Integer>> matrix = buildMatrix( new int[][]{
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        });

        assertThat(ConnectedCellsInAGrid.connectedCell(matrix)).isEqualTo(5);
    }

    List<List<Integer>> buildMatrix(int[][] rows){
        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < rows.length; i++) {
            matrix.add(getAsList(rows[i]));
        }

        return matrix;
    }

    private List<Integer> getAsList(int[] row) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < row.length; i++) {
            list.add(row[i]);
        }

        return list;
    }
}