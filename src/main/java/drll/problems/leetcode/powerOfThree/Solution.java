package drll.problems.leetcode.powerOfThree;

public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        double exponent = Math.log10(n) / Math.log10(3);
        Double decimal = Double.parseDouble(Double.toString(exponent).split("\\.")[1]);
        return decimal == 0;
    }
}