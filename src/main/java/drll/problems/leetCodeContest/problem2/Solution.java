package drll.problems.leetCodeContest.problem2;

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
            positions.replace(poll[0], '1');
            positions.replace(poll[1], '0');

            if(poll[0] - 1 >= 0  &&  positions.get(poll[0] - 1) == '0'){
                tmp.add(new Integer[]{poll[0] - 1, poll[0]});
            }
            if(poll[1] + 1 < s.length()  &&  positions.get(poll[1] + 1) == '1'){
                tmp.add(new Integer[]{poll[1], poll[1] + 1});
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