package org.example;

public class SudokuSolver {

   public boolean isSafe(int[][] board, int row, int col, int num, int n) {
        // check horizontally
        for (int j = 0; j < n; j++)
            if (board[row][j] == num)
                return false;

        // check vertically
        for (int i = 0; i < n; i++)
            if (board[i][col] == num)
                return false;

        int startRow = row - row % 3,
                startCol = col - col % 3;

        // check within the section (3 * 3)(n = 3)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num)
                    return false;
            }
        }

        return true;
    }

    boolean solve(int[][] board, int row, int col, int n) {
        // avoid further tracking if all cells are explored
        if (row == n - 1 && col == n)
            return true;

        // move to next row
        if (col == n) {
            row++;
            col = 0;
        }

        // check for next element horizontally if element is
        // already present
        if (board[row][col] != 0)
            return solve(board, row, col + 1, n);

        // if present value is 0, replace it with values from 0-9
        for (int num = 1; num < n + 1; num++) {
            if (isSafe(board, row, col, num, n)) {
                board[row][col] = num;
        // check for next column
                if (solve(board, row, col + 1, n)) {
                    return true;
                }
            }
            board[row][col] = 0;
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        int n = board[0].length;
        int grid[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = Integer.parseInt(String.valueOf(board[i][j]));
                }
            }
        }
        solve(grid, 0, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    board[i][j] = '.';
                } else {
                    board[i][j] = (char) (grid[i][j] + '0');
                }
            }
        }
    }

}
