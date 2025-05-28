package drll.problems.leetcode.optimal_partition_of_string;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int partitionString(String s) {
        Set<Character> partition = new HashSet<>();
        int count = 1;
        for (int i = 0, length = s.length(); i < length; i++) {
            Character character = s.charAt(i);

            if(partition.contains(character)){
                count++;
                partition.clear();
            }

            partition.add(character);
        }
        return count;
    }
}