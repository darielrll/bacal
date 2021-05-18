package drll.problems.leetcode.sumOfFlooredPairs;

import java.util.*;

public class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        Map<Integer,Integer> duplicatesAscOrdered = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();
        for (int num : nums) {
            if (duplicatesAscOrdered.containsKey(num)) {
                duplicatesAscOrdered.put(num, duplicatesAscOrdered.get(num) + 1);
            } else {
                duplicatesAscOrdered.put(num, 1);
                numbers.add(num);
            }
        }
        numbers.sort((o1, o2) -> o2 - o1);
        
        long sumOfFlooredPairs = 0;

        for (int i = 0; i < numbers.size(); i++) {
            Integer upNumber = duplicatesAscOrdered.get(numbers.get(i));
            sumOfFlooredPairs += upNumber + (long) (upNumber - 1) * upNumber;
            for (int j = i + 1; j < numbers.size(); j++) {
                Integer downNumber = duplicatesAscOrdered.get(numbers.get(j));
                sumOfFlooredPairs +=
                        ((long) numbers.get(i) / numbers.get(j))
                                * upNumber
                                * downNumber;
            }
        }
        return (int) (sumOfFlooredPairs % 1000000007);
    }
}