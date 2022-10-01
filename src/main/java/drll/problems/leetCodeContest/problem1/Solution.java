package drll.problems.leetCodeContest.problem1;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        int[][] positions = new int[names.length][2];

        for (int i = 0; i < names.length; i++) {
            positions[i][0] = i;
            positions[i][1] = heights[i];
        }

        Arrays.sort(positions, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        String[] namesOrdered = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            namesOrdered[i] = names[positions[i][0]];
        }

        return namesOrdered;
    }
}