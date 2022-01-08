
package drll.problems.hackerRank.connectedCellsInAGrid;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class ConnectedCellsInAGrid {

    public static int connectedCell(List<List<Integer>> matrix) {
        int maxRegionArea = 0;
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            for (int j = 0; j < row.size(); j++) {
                if(visited(row, j)){
                    continue;
                }
                int area = getRegionArea(matrix, i, j);
                if (area > maxRegionArea) {
                    maxRegionArea = area;
                }
            }
        }

        return maxRegionArea;
    }

    private static int getRegionArea(List<List<Integer>> matrix, int row, int col) {
        int[][] movementArray = new int[][]{
                {-1, 0, 1, 0, -1, -1, 1, 1}, // row
                {0, 1, 0, 1, -1, 1, 1, -1}  // col
        };

        Queue<Coordinate> region = new ArrayDeque<Coordinate>();
        region.add(new Coordinate(row, col));
        while(!region.isEmpty()){
            Coordinate coordinate = region.poll();
            for (int i = 0; i < 7; i++) {
                Coordinate adjacent = new Coordinate(
                coordinate.row + movementArray[0][i],
                 coordinate.col + movementArray[1][i]
            );
                if(isValidaCoordinate(adjacent, matrix)){

                }
            }
        }

        return -1;
    }

    private static boolean visited(List<Integer> row, int j) {
        return row.get(j) != 0  &&  row.get(j) != 1;
    }

    private static class Coordinate {
        public int row, col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}