package drll.problems.leetcode.NodeWithHighestEdgeScore;

public class Solution {
    public int edgeScore(int[] edges) {
        long[] edgeScores = new long[edges.length];

        for (int i = 0; i < edges.length; i++) {
            edgeScores[edges[i]] += i;
        }

        long highestEdgeScore = -1;
        int highestEdgeScorePosition = -1;
        for (int i = 0; i < edgeScores.length; i++) {
            if(highestEdgeScore < edgeScores[i]){
                highestEdgeScore = edgeScores[i];
                highestEdgeScorePosition = i;
            }
        }

        return highestEdgeScorePosition;
    }
}