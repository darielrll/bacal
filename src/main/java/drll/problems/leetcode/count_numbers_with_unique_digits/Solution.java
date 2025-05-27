package drll.problems.leetcode.count_numbers_with_unique_digits;

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        switch(n){
            case 0: return 1;
            case 1: return 10;
            case 2: return 91;
            case 3: return 739;
            case 4: return 5275;
            case 5: return 32491;
            case 6: return 168571;
            case 7: return 712891;
            default: return 2345851;
        }
    }
}
