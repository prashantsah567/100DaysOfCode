public class Day63 {
    public static int minimumTrial(int f, int e) {
        // declare a dp array of size floor+1 and egg+1 (0th index of egg will be dummy
        // values)
        int[][] dp = new int[f + 1][e + 1];
        // filling out the dp array for the base cases
        // when the floor is 0 the value is 0 and when its 1 the value 1
        for (int i = 1; i <= e; i++) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
        // when there is only 1 egg - minimum trials will be number of floor
        for (int j = 1; j <= f; j++) {
            dp[j][1] = j;
        }

        // now fill out the rest of the values of the dp array
        for (int i = 2; i <= f; i++) {
            for (int j = 2; j <= e; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= i; x++) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));
                }
            }
        }
        return dp[f][e];
    }

    public static void main(String[] args) {
        int floor = 10;
        int egg = 2;
        System.out.println(
                "The minimum number of trials to find out threashold of egg break is: " + minimumTrial(floor, egg));

    }
}
