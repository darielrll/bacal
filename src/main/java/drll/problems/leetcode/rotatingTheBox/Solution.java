package drll.problems.leetcode.rotatingTheBox;

public class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char[][] rotated = new char[box[0].length][box.length];
        fillWithDots(rotated);

        for (int row = box.length - 1; row >= 0; row--) {
            int availableRowInColumnPosition = box[0].length - 1;
            for (int column = box[0].length - 1; column >= 0; column--) {
                if (box[row][column] == '.') {
                    rotated[column][box.length - 1 - row] = '.';
                } else if (box[row][column] == '*') {
                    rotated[column][box.length - 1 - row] = '*';
                    availableRowInColumnPosition = column - 1;
                } else {
                    rotated[availableRowInColumnPosition][box.length - 1 - row] = '#';
                    availableRowInColumnPosition--;
                }
            }
        }

        return rotated;
    }

    private void fillWithDots(char[][] box){
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                box[i][j] = '.';
            }
        }
    }
}