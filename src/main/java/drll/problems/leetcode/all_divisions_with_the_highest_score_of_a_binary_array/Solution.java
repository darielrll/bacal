package drll.problems.leetcode.all_divisions_with_the_highest_score_of_a_binary_array;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int[][] counts = new int[3][nums.length + 1];

        // counting 0 from left to right
        for (int i = 0, length = nums.length; i < length; i++) {
            if(i == 0  &&  nums[i] == 0){
                counts[0][ i + 1 ] = 1;
                continue;
            }
            if(nums[i] == 0){
                counts[0][ i + 1 ] = 1 + counts[0][ i ];
            }
            else{
                counts[0][ i + 1 ] = counts[0][ i ];
            }
        }

        // counting 1 from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == 1){
                counts[1][ i ] = 1 + counts[1][ i + 1 ];
            }
            else{
                counts[1][ i ] = counts[1][ i + 1 ];
            }
        }

        // adding vertical
        for (int i = 0, length = counts[0].length; i < length; i++) {
            counts[2][i] = counts[0][i] + counts[1][i];
        }

        int maxScore = 0;
        for (int i = 0, length = counts[0].length; i < length; i++) {
            if(maxScore < counts[2][i]){
                maxScore = counts[2][i];
            }
        }

        List<Integer> maxScoreIndices = new ArrayList<>();
        for (int i = 0, length = counts[0].length; i < length; i++) {
            if(maxScore == counts[2][i]){
                maxScoreIndices.add(i);
            }
        }
        return maxScoreIndices;
    }
}