package drll.problems.leetcode.ShiftingLettersII;

public class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] lineSweep = new int[s.length() + 1];

        for (int[] shift : shifts) {
            lineSweep[shift[0]] += shift[2] == 0 ? -1 : 1;
            lineSweep[shift[1] + 1] += (shift[2] == 0 ? -1 : 1) * -1;
        }

        StringBuilder builder = new StringBuilder();
        int sum = 0;
        final int FIRST_ASCII_CHARACTER_a = 97;

        for (int i = 0; i < s.length(); i++) {
            sum += lineSweep[i] % 26;
            int characterPosition = (s.charAt(i) - FIRST_ASCII_CHARACTER_a + sum) % 26;

            builder.append((char)(FIRST_ASCII_CHARACTER_a + (characterPosition < 0
                        ? 26 + characterPosition
                        : characterPosition)));
        }

        return builder.toString();
    }
}