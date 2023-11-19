public class Day26GameOfLife {
    public static void main(String[] args){
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};

        gameOfLife(board);
        printMatrix(board);
    }
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Use a separate array to store the updated state
        int[][] nextState = new int[m][n];

        // Define eight possible directions
        int[] directions = {-1, 0, 1};

        // Iterate through each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Check the eight possible neighbors
                for (int x : directions) {
                    for (int y : directions) {
                        if (x == 0 && y == 0) continue; // Skip the current cell
                        int ni = i + x;
                        int nj = j + y;

                        // Check if the neighbor is within the bounds of the board
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                            liveNeighbors += board[ni][nj];
                        }
                    }
                }

                // Apply the rules to determine the next state
                if (board[i][j] == 1) {
                    // Live cell
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextState[i][j] = 0; // Cell dies
                    } else {
                        nextState[i][j] = 1; // Cell survives
                    }
                } else {
                    // Dead cell
                    if (liveNeighbors == 3) {
                        nextState[i][j] = 1; // Cell becomes alive
                    }
                }
            }
        }

        // Update the original board with the next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = nextState[i][j];
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
