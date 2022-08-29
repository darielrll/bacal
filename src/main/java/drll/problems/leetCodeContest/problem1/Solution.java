package drll.problems.leetCodeContest.problem1;

import java.util.Arrays;

public class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] answers = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int answer = 0;
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(answer + nums[j] <= queries[i]){
                    answer += nums[j];
                    count++;
                }
                else {
                    break;
                }
            }
            answers[i] = count;
        }

        return answers;
    }
}