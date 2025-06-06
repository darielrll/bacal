package drll.problems.leetcode.cells_in_a_range_on_an_excel_sheet;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> cellsInRange(String s) {
        char[] capitals = getCapitalAlphabet();
        List<String> result = new ArrayList<>();

        Character startColumn = s.charAt(0);
        int startRow = Integer.parseInt(String.valueOf(s.charAt(1)));
        Character endColumn = s.charAt(3);
        int endRow = Integer.parseInt(String.valueOf(s.charAt(4)));

        int startColumnIndex = getStartColumnIndex(startColumn, capitals);
        int endColumnIndex = getStartColumnIndex(endColumn, capitals);

        for (int column = startColumnIndex; column <= endColumnIndex; column++){
            for (int j = startRow; j <= endRow; j++){
                result.add(capitals[column] + String.valueOf(j));
            }
        }

        return result;
    }

    private int getStartColumnIndex(Character c, char[] capitals) {
        for (int i = 0; i < capitals.length; i++) {
            if(c.equals(capitals[i])){
                return i;
            }
        }
        return -1;
    }

    private char[] getCapitalAlphabet() {
        return new char[]{
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z'
        };
    }
}