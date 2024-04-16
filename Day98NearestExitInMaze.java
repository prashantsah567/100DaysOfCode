import java.util.*;

public class Day98NearestExitInMaze {
    public static int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length;
        // 2D dirs array to easy move in all four direction
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        // mark the entrance as visited since its not a exit
        int startRow = entrance[0], startCol = entrance[1];
        maze[startRow][startCol] = '+';

        // start BFS from the entrance, and use a queue to store all cells to be visited
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startRow, startCol, 0 });

        while (!queue.isEmpty()) {
            int[] currState = queue.poll();
            int currRow = currState[0], currCol = currState[1], currDistance = currState[2];

            // for the current cell, check its four neighbor cells
            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];

                // if there exists an unvisited empty neighbor
                if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols
                        && maze[nextRow][nextCol] == '.') {
                    // if this empty cell is an exit return distance + 1
                    if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1)
                        return currDistance + 1;
                    // otherwise, add this cell to queue and mark it as visited & updating its
                    // distance
                    maze[nextRow][nextCol] = '+';
                    queue.offer(new int[] { nextRow, nextCol, currDistance + 1 });
                }
            }
        }
        // if we finish iterating without finding an exit return -1
        return -1;
    }

    public static void main(String[] args) {
        char[][] maze = { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+', '+', '.' } };

        int[] entrance = { 1, 2 };

        System.out.println("The nearest exit is " + nearestExit(maze, entrance) + " step away");

    }
}
