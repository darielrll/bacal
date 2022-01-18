
package drll.problems.hackerRank.connectedCellsInAGrid;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class ConnectedCellsInAGrid {

    public static int connectedCell(List<List<Integer>> matrix) {
        int maxRegionSize = 0;
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            for (int j = 0; j < row.size(); j++) {
                if(visited(matrix, i, j)){
                    continue;
                }
                int area = getRegionSize(matrix, i, j);
                if (area > maxRegionSize) {
                    maxRegionSize = area;
                }
            }
        }
        return maxRegionSize;
    }

    private static int getRegionSize(List<List<Integer>> matrix, int row, int col) {
        int[][] movementArray = new int[][]{
                // up, right, down, left, upL, upR, downR, downL
                {  -1,   0,    1,    0,   -1,  -1,    1,     1 }, // row
                {   0,   1,    0,   -1,   -1,   1,    1,    -1 }  // col
        };
        int size = 0;
        final int VISITED_CELL = 2;
        Queue<Coordinate> region = new ArrayDeque<>();
        region.add(new Coordinate(row, col));
        while(!region.isEmpty()){
            Coordinate coordinate = region.poll();
            for (int i = 0; i < 8; i++) {
                Coordinate adjacent = new Coordinate(coordinate.row + movementArray[0][i],
                        coordinate.col + movementArray[1][i]);
                if(isValidCoordinate(matrix, adjacent)  && !visited(matrix, adjacent.row, adjacent.col)) {
                    matrix.get(row).set(col, VISITED_CELL);
                    region.add(adjacent);
                    size++;
                }
            }
        }
        return size;
    }

    private static boolean isValidCoordinate(List<List<Integer>> matrix, Coordinate coordinate) {
        return coordinate.row >= 0  &&  coordinate.row < matrix.size()  &&
            coordinate.col >= 0  &&  coordinate.col < matrix.get(0).size();
    }

    private static boolean visited(List<List<Integer>> matrix, int row, int col) {
        return matrix.get(row).get(col) != 0  &&  matrix.get(row).get(col) != 1;
    }

    static class Coordinate {
        public int row, col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}