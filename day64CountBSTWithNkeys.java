//1. Dynamic programming solution to count the total BST arrangements with N keys
public class day64CountBSTWithNkeys {
    public static int countBST(int n) {
        int[] dp = new int[n + 1];// initialize a dp array of size n+1
        dp[0] = 1;// for 0 key value the count is 1

        for (int i = 1; i <= n; i++) {
            dp[i] = 0; // initializing current dp value as 0
            for (int j = 0; j < i; j++) {
                // the current dp[i] value is calculated as taking 0 on left side and remaining
                // on right side of the root
                // and keep incrementing on left side and decrementing on right side until right
                // side element is 0
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int numberOfKeys = 5;
        System.out.println(
                "The total BST that can be generated with " + numberOfKeys + " keys is: " + countBST(numberOfKeys));
    }
}
