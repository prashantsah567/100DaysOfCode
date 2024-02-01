public class Day61_0_1_knapsack {
    static int knapSack(int w, int wt[], int val[], int n){
        int dp[][] = new int[n+1][w+1];

        for(int i=0; i<=w; i++){
            dp[0][i] = 0;
        }
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=w; j++){
                if(wt[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args){
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 6, 3};
        int w = 10;
        int n = 4;

        System.out.println(knapSack(w, wt, val, n));
    }
}
