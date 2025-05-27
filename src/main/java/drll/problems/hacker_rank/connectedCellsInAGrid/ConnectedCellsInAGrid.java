
package drll.problems.hacker_rank.connectedCellsInAGrid;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class ConnectedCellsInAGrid {

    public static int connectedCell(List<List<Integer>> matrix) {
        int maxRegionSize = 0;
        for (int rowIndex = 0; rowIndex < matrix.size(); rowIndex++) {
            List<Integer> row = matrix.get(rowIndex);

            for (int colIndex = 0; colIndex < row.size(); colIndex++) {
                if (!isFilledCell(matrix, rowIndex, colIndex)) {
                    continue;
                }
                int area = getRegionSize(matrix, rowIndex, colIndex);
                if (area > maxRegionSize) {
                    maxRegionSize = area;
                }
            }
        }
        return maxRegionSize;
    }

    private static int getRegionSize(List<List<Integer>> matrix, int row, int col) {
        int regionSize = 0;
        Queue<Coordinate> region = new ArrayDeque<>();

        Coordinate coordinate = new Coordinate(row, col);
        region.add(coordinate);
        markCellBelongToRegion(matrix, coordinate);

        while (!region.isEmpty()) {
            coordinate = region.poll();
            regionSize++;
            for (int direction = 0; direction < 8; direction++) {
                Coordinate adjacent = getAdjacent(coordinate, direction);
                if (isValidCoordinate(matrix, adjacent) && isFilledCell(matrix, adjacent)) {
                    region.add(adjacent);
                    markCellBelongToRegion(matrix, adjacent);
                }
            }
        }

        return regionSize;
    }

    private static void markCellBelongToRegion(List<List<Integer>> matrix, Coordinate coordinate) {
        final int VISITED_CELL = 2;
        matrix.get(coordinate.row).set(coordinate.col, VISITED_CELL);
    }

    private static Coordinate getAdjacent(Coordinate coordinate, int direction) {
        final int[][] movementArray = new int[][]{
                // up, right, down, left, upL, upR, downR, downL
                {-1, 0, 1, 0, -1, -1, 1, 1}, // row
                {0, 1, 0, -1, -1, 1, 1, -1}  // col
        };
        return new Coordinate(
                coordinate.row + movementArray[0][direction],
                coordinate.col + movementArray[1][direction]
        );
    }

    private static boolean isFilledCell(List<List<Integer>> matrix, Coordinate coordinate) {
        return isFilledCell(matrix, coordinate.row, coordinate.col);
    }

    private static boolean isFilledCell(List<List<Integer>> matrix, int row, int col) {
        return matrix.get(row).get(col) == 1;
    }

    private static boolean isValidCoordinate(List<List<Integer>> matrix, Coordinate coordinate) {
        return coordinate.row >= 0 && coordinate.row < matrix.size() &&
                coordinate.col >= 0 && coordinate.col < matrix.get(0).size();
    }

    static class Coordinate {
        public int row, col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}