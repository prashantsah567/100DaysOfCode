public class Day60ClimbingStairs {
    public static int climbStairs(int n) {
        if(n <= 2) return n;//if number of stairs less than 2, then n is the result 
        int[] dp = new int[n+1];//initialize a dp array of size n+1
        dp[1] = 1;
        dp[2] = 2;
        //a loop that calculates the dp value starting from 3rd stairs which is the addition of its previous two values
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        //the last value in the dp array is our result
        return dp[n];
    }

    public static void main(String[] args){
        int n = 11;

        System.out.println(climbStairs(n));
    }
}
