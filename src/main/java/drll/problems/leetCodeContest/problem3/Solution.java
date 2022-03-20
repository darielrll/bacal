package drll.problems.leetCodeContest.problem3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            return (o2 - o1) < 0 ? -1 : (o2 - o1) > 0 ? 1 : 0;
        });
        for (int num : nums) {
            priorityQueue.add((double) num);
        }
        double sumatory = 0;
        for (int num : nums) {
            sumatory += num;
        }
        double halfSumatory = sumatory / 2.0;

        int minimumOperation = 0;
        while (sumatory > halfSumatory){
            double maxNum = priorityQueue.poll();
            maxNum /= 2;
            sumatory -= maxNum;
            priorityQueue.add(maxNum);

            minimumOperation++;
        }


//        double sumatory = 0;
//        for (int num : nums) {
//            sumatory += num;
//        }
//        double halfSumatory = sumatory / 2.0;
//
//        Arrays.sort(nums);
//        double[] numsDouble = new double[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            numsDouble[i] = nums[i];
//        }
//
//        int minimumOperation = 0;
//        int greaterIndex = numsDouble.length - 1;
//        while (sumatory > halfSumatory){
//            if(numsDouble[greaterIndex] < numsDouble[greaterIndex - 1]){
//                greaterIndex--;
//            }
//            if(numsDouble[greaterIndex] > numsDouble[numsDouble.length - 1]){
//                greaterIndex = numsDouble.length - 1;
//                Arrays.sort(numsDouble);
//            }
//
//            numsDouble[greaterIndex] = numsDouble[greaterIndex] / 2;
//            sumatory -= numsDouble[greaterIndex];
//
//            minimumOperation++;
//        }
        return minimumOperation;
    }
}