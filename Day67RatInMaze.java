public class Day67RatInMaze {
    static int N;// size of maze

    static boolean solveMaze(int maze[][]) {
        int sol[][] = new int[N][N];// to store the solution path

        if (solveMazeRec(maze, 0, 0, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    static boolean solveMazeRec(int maze[][], int i, int j, int sol[][]) {
        // if i & j are last indexes, we reached the end and return true
        if (i == N - 1 && j == N - 1 && maze[i][j] == 1) {
            sol[i][j] = 1;
            return true;
        }
        // check if its safe to proceed - this will cut down the recurssion tree
        if (isSafe(maze, i, j) == true) {
            sol[i][j] = 1;// if its safe then mark the current index as 1
            // we can only move two ways - either down (i+1)
            if (solveMazeRec(maze, i + 1, j, sol))
                return true;
            // or another to the right (j+1)
            if (solveMazeRec(maze, i, j + 1, sol))
                return true;
            // if both path are unsafe to travel then mark it as 0
            // which means no solution from this index
            sol[i][j] = 0;
        }

        return false;
    }

    // safe funciton that checks if i & j are less than N
    // and we can proceed with current index (if it has value 1)
    static boolean isSafe(int maze[][], int i, int j) {
        return (i < N && j < N && maze[i][j] == 1);
    }

    // this will print the solution path
    static void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        N = maze.length;
        solveMaze(maze);
    }
}
