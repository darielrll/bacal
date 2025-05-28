package drll.problems.leetcode.strictly_palindromic_number;

public class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            String nInBase = convertDecimalToBaseB(n, i);
            if(!isPalindrome(nInBase, 0)){
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String word, int i) {
        if(i >= (word.length() / 2)){
            return true;
        }
        if(word.charAt(i) != word.charAt(word.length() - 1 - i)){
            return false;
        }
        return isPalindrome(word, i + 1);
    }

    public String convertDecimalToBaseB(Integer decimal, Integer base){
        if(decimal < base){
            return decimal.toString();
        }
        int rest = decimal % base;
        return convertDecimalToBaseB(decimal / base, base) + rest;
    }
}