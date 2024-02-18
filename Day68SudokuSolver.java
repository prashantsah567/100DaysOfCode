public class Day68SudokuSolver {
    public static boolean solveSudoku(int[][] board, int n) {
        int i = -1, j = -1;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (board[i][j] == 0) {// we found the empty slot
                    break;
                }
            }
            if (j < n)// break if the inner loop was terminated early
                break;
        }

        if (i == n && j == n) {// reached the end
            return true;
        }
        // now try each value from 1..N to check which one fits
        for (int x = 1; x <= n; x++) {
            // before filling the value first we need to check if
            // its safe to insert the current value or not
            if (isSafe(board, i, j, x)) {
                board[i][j] = x;// if its safe we insert the value and recrusively call to fill other values
                if (solveSudoku(board, n))
                    return true;
                // if other's cells cannot be filled with the current value we mark it as 0 and
                // try another value
                else
                    board[i][j] = 0;
            }
        }
        return false;
    }

    // now implement the isSafe method that checks the row, columns and grid
    private static boolean isSafe(int[][] board, int i, int j, int x) {
        // this checks rows and columns
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == x || board[i][k] == x) {
                return false;
            }
        }
        // this checks grid by first finding out the start of row and col
        int sqrt = (int) Math.sqrt(board.length);
        int row_start = i - i % sqrt;
        int col_start = j - j % sqrt;

        for (int row = 0; row < sqrt; row++) {
            for (int col = 0; col < sqrt; col++) {
                if (board[row + row_start][col + col_start] == x) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int n = board.length;

        if (solveSudoku(board, n)) {
            print(board, n);
        } else {
            System.out.println("No solution");
        }
    }

    private static void print(int[][] board, int n) {
        for (int r = 0; r < n; r++) {
            for (int d = 0; d < n; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
