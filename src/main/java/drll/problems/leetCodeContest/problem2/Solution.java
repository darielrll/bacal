package drll.problems.leetCodeContest.problem2;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int partitionString(String s) {
        Set<Character> partition = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);

            if(partition.contains(character)){
                count++;
                partition.clear();
            }

            partition.add(character);
        }
        return count + 1;
    }
}