package drll.problems.leetcode.minimum_operations_to_halve_array_sum;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> (o2 - o1) < 0 ? -1 : (o2 - o1) > 0 ? 1 : 0
        );
        for (int num : nums) {
            priorityQueue.add((double) num);
        }

        double sumatory = Arrays.stream(nums).asDoubleStream().sum();
        double halfSumatory = sumatory / 2;

        int minimumOperation = 0;
        while (sumatory > halfSumatory){
            double maxNum = priorityQueue.poll() / 2;
            sumatory -= maxNum;
            priorityQueue.add(maxNum);

            minimumOperation++;
        }
        return minimumOperation;
    }
}