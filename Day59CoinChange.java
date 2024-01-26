import java.util.Arrays;

public class Day59CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;//edge case when amount is less than 1
        //create a dp array of size amount + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);//populate the array with max amount - (amount+1)

        dp[0] = 0; // Base case - we don't need any coin for 0 amount

        for (int currAmount = 1; currAmount <= amount; currAmount++) {
            //try each coin
            for (int coin : coins) {
                if (coin <= currAmount) {
                    dp[currAmount] = Math.min(dp[currAmount], 1 + dp[currAmount - coin]);
                }
            }
        }

        return (dp[amount] > amount) ? -1 : dp[amount];
    }

    public static void main(String[] args){
        int[] coins = {1, 2, 5};
        int amount = 21;

        System.out.println(coinChange(coins, amount));
    }
}
