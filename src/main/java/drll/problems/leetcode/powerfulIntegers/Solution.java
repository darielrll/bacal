package drll.problems.leetcode.powerfulIntegers;

import java.util.*;

public class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int maxExponentX = getMaxExponent(x, bound);
        int maxExponentY = getMaxExponent(y, bound);
        Set<Integer> powerfulIntegers = new HashSet<>();

        for (int i = 0; i <= maxExponentX; i++) {
            for (int j = 0; j <= maxExponentY; j++) {
                int powerFulInteger = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if(powerFulInteger <= bound){
                    powerfulIntegers.add(powerFulInteger);
                }
                if(y == 1){
                    break;
                }
            }
            if(x == 1){
                break;
            }
        }

        return Arrays.asList(powerfulIntegers.toArray(new Integer[0]));
    }

    private int getMaxExponent(int x, int bound) {
        return (int) (Math.log10(bound) / Math.log10(x));
    }
}