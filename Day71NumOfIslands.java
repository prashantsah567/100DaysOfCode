public class Day71NumOfIslands {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        // traverse through the matrix and only count or call dfs if current value is 1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;// increament the count for disconnected compnonent/islands
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int row, int col) {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        // if the row or col index is out of grid or 0, return
        if (row < 0 || col < 0 || row >= rowNum || col >= colNum || grid[row][col] == '0') {
            return;
        }
        // sink the current cell to avoid repetation or keep track of visited cell
        grid[row][col] = '0';
        // recursively call for left right top & down cells
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    public static void main(String[] args) {
        char[][] grid = { { '0', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '0', '0', '1', '0' },
                { '0', '0', '1', '0', '1' } };

        System.out.println("The total number of islands is: " + numIslands(grid));
    }
}
