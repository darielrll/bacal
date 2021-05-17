package drll.problems.leetcode.sumOfFlooredPairs;

import java.util.*;

public class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        Map<Integer,Integer> duplicatesAscOrdered = new TreeMap<>();
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
            sumOfFlooredPairs += duplicatesAscOrdered.get(numbers.get(i)) + (duplicatesAscOrdered.get(numbers.get(i)) - 1) * duplicatesAscOrdered.get(numbers.get(i));
            for (int j = i + 1; j < numbers.size(); j++) {
                sumOfFlooredPairs +=
                        numbers.get(i) / numbers.get(j)
                    + (numbers.get(i) / numbers.get(j) * (duplicatesAscOrdered.get(numbers.get(i)) - 1))
                    + (numbers.get(i) / numbers.get(j) * (duplicatesAscOrdered.get(numbers.get(j)) - 1));
            }
        }
        /*

        esto fue lo ultimo que puse, el ultimo numero no se estaba teniendo en cuenta y paso el ultimo caos de prueba

        * */
//        sumOfFlooredPairs += duplicatesAscOrdered.get(numbers.get(numbers.size() - 1))
//                + (duplicatesAscOrdered.get(numbers.get(numbers.size() - 1)) - 1) * duplicatesAscOrdered.get(numbers.get(numbers.size() - 1));

        return (int) (sumOfFlooredPairs % 1000000007);
    }
//    public int sumOfFlooredPairs(int[] nums) {
//        Map<Integer,Integer> duplicatesAscOrdered = new TreeMap<>();
//        List<Integer> numbers = new ArrayList<>();
//        for (int num : nums) {
//            if (duplicatesAscOrdered.containsKey(num)) {
//                duplicatesAscOrdered.put(num, duplicatesAscOrdered.get(num) + 1);
//            } else {
//                duplicatesAscOrdered.put(num, 1);
//                numbers.add(num);
//            }
//        }
//        numbers.sort((o1, o2) -> o2 - o1);
//
//        long sumOfFlooredPairs = 0;
//
//        Map.Entry[] entries = duplicatesAscOrdered.entrySet().toArray(new Map.Entry[0]);
//        for (int i = entries.length - 1; i >= 0; i--) {
//            Map.Entry<Integer, Integer> entry = entries[i];
//            if(entry.getValue() == 1){
//                sumOfFlooredPairs++;
//            }
//            else {
//                sumOfFlooredPairs += (long) entry.getKey() * entry.getValue();
//            }
//            for (int j = i - 1; j >= 0; j--) {
//                Map.Entry<Integer, Integer> entryMinor = entries[i];
//                if (entryMinor.getValue() == 1) {
//                    sumOfFlooredPairs += (long) entry.getKey() / entryMinor.getKey() * (entry.getValue() - 1);
//                } else {
//                    sumOfFlooredPairs += (long) entry.getKey() / entryMinor.getKey() * (entry.getValue() - 1) * (entryMinor.getValue() - 1);
//                }
//            }
//        }
//
//        for (int i = 0; i < numbers.size(); i++) {
//            for (int j = i + 1; j < numbers.size(); j++) {
//                sumOfFlooredPairs += numbers.get(i) / numbers.get(j);
//            }
//        }
//
//        return (int) (sumOfFlooredPairs % 1000000007);
//    }
}