package drll.problems.leetcode.SmallestValueOfTheRearrangedNumber;

import java.util.Arrays;

public class Solution {
    public long smallestNumber(long num) {
        boolean negative = false;
        if(num < 0){
            num *= -1;
            negative = true;
        }
        char[] numberCharacters = String.valueOf(num).toCharArray();
        int[] digits = new int[numberCharacters.length];
        for (int i = 0; i < numberCharacters.length; i++) {
            digits[i] = Integer.parseInt(String.valueOf(numberCharacters[i]));
        }
        Arrays.sort(digits);

        StringBuilder number = new StringBuilder();
        if(negative){
            for (int i = digits.length - 1; i >= 0; i--) {
                number.append(digits[i]);
            }
            return -1 * Long.parseLong(number.toString());
        }

        if(digits[0] == 0){
            for (int i = 0, length = digits.length; i < length; i++) {
                if(digits[i] != 0){
                    digits[0] = digits[i];
                    digits[i] = 0;
                    break;
                }
            }
        }

        for (int digit : digits) {
            number.append(digit);
        }
        return Long.parseLong(number.toString());
    }
}