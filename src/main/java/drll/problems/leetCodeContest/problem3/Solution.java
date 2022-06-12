package drll.problems.leetCodeContest.problem3;

public class Solution {
    public long countSubarrays(int[] nums, long k) {
//        long sum = 0, res = 0;
//        for (int i = 0, j = 0; i < nums.length; ++i) {
//            sum += nums[i];
//            while (sum * (i - j + 1) >= k)
//                sum -= nums[j++];
//            res += i - j + 1;
//        }
//        return res;

        long score = 0;

        int[] partialSums = buildPartialSums(nums);

        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                long segmentSum = getPartialSumFrom(start, end, partialSums);
                int segmentLength = end - start + 1;

                if(segmentSum * segmentLength < k){
                    score++;
                }
                else {
                    break;
                }
            }
        }

        return score;
    }

    private long getPartialSumFrom(int start, int end, int[] partialSums) {
        int previousSum = start == 0 ? 0 : partialSums[start - 1];
        return partialSums[end] - previousSum;
    }

    private int[] buildPartialSums(int[] nums) {
        int[] partialSums = new int[nums.length];
        partialSums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            partialSums[i] = partialSums[i-1] + nums[i];
        }
        return partialSums;
    }
}