package drll.problems.leetcode.SpiralMatrixIV;

public class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] spiral = prepareSpiral(m, n);

        int currentRow = 0;
        int currentCol = 0;
        int[][] direction = {
                {0,1, 0,-1},
                {1,0,-1, 0 }
        };
        int currentDirection = 0;

        while (head != null){
            spiral[currentRow][currentCol] = head.val;
            head = head.next;

            int tmpRow = currentRow + direction[0][currentDirection];
            int tmpCol = currentCol + direction[1][currentDirection];

            if(tmpRow >= 0  &&  tmpRow < m  &&
                    tmpCol >= 0  &&  tmpCol < n  &&
                    spiral[tmpRow][tmpCol] == -1){
                currentRow = tmpRow;
                currentCol = tmpCol;
            }
            else{
                currentDirection = (currentDirection + 1) % 4;
                currentRow += direction[0][currentDirection];
                currentCol += direction[1][currentDirection];
            }
        }


        return spiral;
    }

    private int[][] prepareSpiral(int m, int n) {
        int[][] spiral = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                spiral[i][j] = -1;
            }
        }

        return spiral;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}