package drll.problems.leetcode.superPalindromes;

public class Solution {
    public int superpalindromesInRange(String left, String right) {
        long lefNumber = Long.parseLong(left);
        long rightNumber = Long.parseLong(right);

        int superPalindromes = 0;

        for (long i = 1; i <= rightNumber; i++) {
            long pow = (long) Math.pow(i, 2);
            if(!esPalindromeNumber(i)){
                continue;
            }
            if(pow < lefNumber){
                continue;
            }
            else{
                int a = 0;
            }
            if(pow > rightNumber){
                break;
            }
            if(esPalindromeNumber(pow)){
                superPalindromes++;
            }
        }
        
        return superPalindromes;
    }

    private boolean esPalindromeNumber(long number) {
        String numberString = Long.toString(number);
        return esPalindrome(numberString, 0, numberString.length() - 1);
    }

    private boolean esPalindrome(String number, int init, int end) {
        if(init > end){
            return true;
        }
        if(number.charAt(init) != number.charAt(end)){
            return false;
        }
        return esPalindrome(number, init + 1, end - 1);
    }
}