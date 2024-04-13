public class Day96NumOfProvinces {

    // Number of Provinces
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numOfProvinces = 0;
        boolean[] visit = new boolean[n];// to keep track of visited components

        // loop through component/province (each row)
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {// if not already visited
                numOfProvinces++;
                dfs(i, isConnected, visit);// helper method doing dfs to find each connected component
            }
        }
        return numOfProvinces;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visit) {
        visit[i] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visit[j]) {
                dfs(j, isConnected, visit);// this recursive dfs will mark all the connected component as true
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        Day96NumOfProvinces solution = new Day96NumOfProvinces();

        System.out.println("The number of Provinces are: " + solution.findCircleNum(isConnected));
    }
}
