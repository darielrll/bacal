package drll.problems.leetcode.sumOfFlooredPairs;

import java.util.*;

public class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        
        long sumOfFlooredPairs = 0;
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 0; i--) {

        }
        
        return (int) (sumOfFlooredPairs % 1000000007);
    }

//    public int sumOfFlooredPairs(int[] nums) {
//        Map<Integer,Integer> duplicates = new HashMap<>();
//        List<Integer> numbers = new ArrayList<>();
//        for (int num : nums) {
//            if (duplicates.containsKey(num)) {
//                duplicates.put(num, duplicates.get(num) + 1);
//            } else {
//                duplicates.put(num, 1);
//                numbers.add(num);
//            }
//        }
//        numbers.sort((o1, o2) -> o2 - o1);
//
//        long sumOfFlooredPairs = 0;
//
//        for (int i = 0; i < numbers.size(); i++) {
//            Integer upNumDuplicates = duplicates.get(numbers.get(i));
//            sumOfFlooredPairs += Math.pow(upNumDuplicates, 2);
//            for (int j = i + 1; j < numbers.size(); j++) {
//                Integer downNumber = duplicates.get(numbers.get(j));
//                sumOfFlooredPairs +=
//                        ((long) numbers.get(i) / numbers.get(j))
//                                * upNumDuplicates
//                                * downNumber;
//            }
//        }
//        return (int) (sumOfFlooredPairs % 1000000007);
//    }
}