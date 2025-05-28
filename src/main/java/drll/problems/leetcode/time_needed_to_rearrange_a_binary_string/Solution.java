package drll.problems.leetcode.time_needed_to_rearrange_a_binary_string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int secondsToRemoveOccurrences(String s) {
        HashMap<Integer, Character> positions = new HashMap<>();
        positions.put(0, s.charAt(0));
        Queue<Integer[]> inversions = new LinkedList<>();

        for (int i = 1; i < s.length(); i++) {
            positions.put(i, s.charAt(i));
            if(s.charAt(i - 1) == '0'  &&  s.charAt(i) == '1'){
                inversions.add(new Integer[]{i-1, i});
            }
        }

        int seconds = 0;
        Queue<Integer[]> tmp = new LinkedList<>();
        while (!inversions.isEmpty()){
            Integer[] poll = inversions.poll();
            Integer positionOne = poll[0];
            Integer positionTwo = poll[1];

            positions.replace(positionOne, '1');
            positions.replace(positionTwo, '0');

            if(positionOne - 1 >= 0  &&  positions.get(positionOne - 1) == '0'){
                tmp.add(new Integer[]{positionOne - 1, positionOne});
            }
            if(positionTwo + 1 < s.length()  &&  positions.get(positionTwo + 1) == '1'){
                tmp.add(new Integer[]{positionTwo, positionTwo + 1});
            }

            if(inversions.isEmpty()){
                inversions = tmp;
                tmp = new LinkedList<>();
                seconds++;
            }
        }

        return seconds;
    }
}