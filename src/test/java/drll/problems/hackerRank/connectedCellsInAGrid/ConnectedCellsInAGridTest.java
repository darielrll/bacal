package drll.problems.hackerRank.connectedCellsInAGrid;

import drll.problems.hackerRank.compareTriplets.CompareTriplets;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConnectedCellsInAGridTest {
    @Test
    void should_return_largest_area_is_3(){
        ConnectedCellsInAGrid connectedCellsInAGrid = new ConnectedCellsInAGrid();

        List<List<Integer>> matrix = buildMatrix( new int[][]{
                {1, 1, 0},
                {1, 0, 0},
                {0, 0, 1}
        });

        assertThat(connectedCellsInAGrid.connectedCell(matrix)).isEqualTo(3);
    }

    @Test
    void should_return_largest_area_is_5(){
        ConnectedCellsInAGrid connectedCellsInAGrid = new ConnectedCellsInAGrid();

        List<List<Integer>> matrix = buildMatrix( new int[][]{
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        });

        assertThat(connectedCellsInAGrid.connectedCell(matrix)).isEqualTo(3);
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