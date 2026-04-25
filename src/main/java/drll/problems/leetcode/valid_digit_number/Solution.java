package drll.problems.leetcode.valid_digit_number;

public class Solution {
    public boolean validDigit(int n, int x) {
        String numberStr = String.valueOf(n);
        if(numberStr.startsWith(String.valueOf(x))) {
            return false;
        }
        return numberStr.contains(String.valueOf(x));
    }
}