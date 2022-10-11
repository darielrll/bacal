package drll.problems.leetcode.DivideIntervalsIntoMinimumNumberOfGroups;

public class Solution {
    public int minGroups(int[][] intervals) {

        int maxRight = 0;
        for (int[] interval : intervals) {
            maxRight = Math.max(maxRight,
                    Math.max(interval[0], interval[1]));
        }

        int[] lineSweep = new int[maxRight + 2];
        for (int[] interval : intervals) {
            lineSweep[interval[0]] += 1;
            lineSweep[interval[1] + 1] -= 1;
        }

        int currentHeight = 0;
        int maxHeight = currentHeight;
        for (int height : lineSweep) {
            currentHeight += height;
            if (currentHeight > maxHeight) {
                maxHeight = currentHeight;
            }
        }

        return maxHeight;
    }
}