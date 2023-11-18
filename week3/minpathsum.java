public class Solution {
    public int minPathSum(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] res = new int[ROWS + 1][COLS + 1];

        // Initialize all cells to Integer.MAX_VALUE
        for (int r = 0; r <= ROWS; r++) {
            for (int c = 0; c <= COLS; c++) {
                res[r][c] = Integer.MAX_VALUE;
            }
        }
        res[ROWS - 1][COLS] = 0;

        for (int r = ROWS - 1; r >= 0; r--) {
            for (int c = COLS - 1; c >= 0; c--) {
                res[r][c] = grid[r][c] + Math.min(res[r + 1][c], res[r][c + 1]);
            }
        }

        return res[0][0];
    }
}
