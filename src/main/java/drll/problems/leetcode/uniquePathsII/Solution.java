package drll.problems.leetcode.uniquePathsII;

import java.util.List;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 1  &&  obstacleGrid[0].length == 1){
            return obstacleGrid[0][0] == 0 ? 1 : 0;
        }

        int[][] pathsCount = new int[obstacleGrid.length][obstacleGrid[0].length];

        fillFirstRow(obstacleGrid, pathsCount);
        fillFirstCol(obstacleGrid, pathsCount);

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 1){
                    continue;
                }
                int upperPathCount = getUpperPathCount(obstacleGrid, pathsCount, i, j);
                int leftPathCount = getLeftPathCount(obstacleGrid, pathsCount, i, j);

                pathsCount[i][j] = upperPathCount + leftPathCount;
            }
        }
        
        return pathsCount[pathsCount.length - 1][pathsCount[0].length - 1];
    }

    private void fillFirstRow(int[][] obstacleGrid, int[][] pathsCount){
        for (int i = 0; i < pathsCount[0].length; i++) {
            if(obstacleGrid[0][i] == 1){
                break;
            }
            pathsCount[0][i] = 1;
        }
    }

    private void fillFirstCol(int[][] obstacleGrid, int[][] pathsCount){
        for (int i = 0; i < pathsCount.length; i++) {
            if(obstacleGrid[i][0] == 1){
                break;
            }
            pathsCount[i][0] = 1;
        }
    }

    private int getLeftPathCount(int[][] obstacleGrid, int[][] pathsCount, int row, int col) {
        int leftCol = col - 1;
        if(leftCol < 0  ||  obstacleGrid[row][leftCol] == 1){
            return 0;
        }
        return pathsCount[row][leftCol];
    }

    private int getUpperPathCount(int[][] obstacleGrid, int[][] pathsCount, int row, int col) {
        int upperRow = row - 1;
        if(obstacleGrid[upperRow][col] == 1){
            return 0;
        }
        return pathsCount[upperRow][col];
    }
}