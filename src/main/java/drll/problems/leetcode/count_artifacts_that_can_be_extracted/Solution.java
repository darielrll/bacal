package drll.problems.leetcode.count_artifacts_that_can_be_extracted;

public class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int artifactsExtracted = 0;

        int[][] grid = new int[n][n];
        for (int[] ints : dig) {
            grid[ints[0]][ints[1]] = 1;
        }
        for (int[] artifact : artifacts) {
            if (artifactRemoved(grid, artifact)) {
                artifactsExtracted++;
            }
        }

        return artifactsExtracted;
    }

    private boolean artifactRemoved(int[][] grid, int[] artifacts) {
        for (int j = artifacts[0]; j <= artifacts[2]; j++) {
            for (int k = artifacts[1]; k <= artifacts[3]; k++) {
                if(grid[j][k] != 1){
                    return false;
                }
            }
        }
        return true;
    }
}