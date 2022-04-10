package drll.problems.leetcode.MaximumProductAfterKIncrements;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int j : nums) {
            priorityQueue.add(j);
        }
        while (k > 0){
            int minimum = priorityQueue.poll();
            minimum++;
            priorityQueue.add(minimum);
            k--;
        }
        int mod = 1000000007;
        long product = priorityQueue.poll();
        while (!priorityQueue.isEmpty()){
            Integer num = priorityQueue.poll();
            product = product % mod  *  num % mod;
        }

        return (int) product;
    }
}