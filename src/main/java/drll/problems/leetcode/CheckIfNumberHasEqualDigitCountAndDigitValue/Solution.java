package drll.problems.leetcode.CheckIfNumberHasEqualDigitCountAndDigitValue;

import java.util.HashMap;

public class Solution {
    public boolean digitCount(String num) {
        if(num.length() == 1){
            return false;
        }

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            Integer digit = Integer.parseInt(String.valueOf(num.charAt(i)));
            if(counter.containsKey(digit)){
                counter.put(digit, counter.get(digit) + 1);
            }
            else {
                counter.put(digit, 1);
            }
        }

        for (int i = 0; i < num.length(); i++) {
            Integer digit = Integer.parseInt(String.valueOf(num.charAt(i)));
            Integer checkCount = counter.containsKey(i) ? counter.get(i) : 0;
            if(!checkCount.equals(digit)){
                return false;
            }
        }
        return true;
    }
}