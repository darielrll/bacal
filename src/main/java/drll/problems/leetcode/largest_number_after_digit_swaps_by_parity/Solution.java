package drll.problems.leetcode.largest_number_after_digit_swaps_by_parity;

public class Solution {
    public int largestInteger(int num) {
        char[] charNums = Integer.toString(num).toCharArray();
        int[] digists = new int[charNums.length];
        for (int i = 0; i < charNums.length; i++) {
            digists[i] = Integer.parseInt((String.valueOf(charNums[i])));
        }

        for (int i = 0; i < digists.length; i++) {
            for (int j = i + 1; j < digists.length; j++) {
                if(digists[j] > digists[i]  &&  digists[j] % 2 == digists[i] % 2){
                    int tmp = digists[i];
                    digists[i] = digists[j];
                    digists[j] = tmp;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < digists.length; i++) {
            builder.append(digists[i]);
        }
        return Integer.parseInt(builder.toString());
    }
}