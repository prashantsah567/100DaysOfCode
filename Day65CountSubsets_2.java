//2. DP approach
public class Day65CountSubsets_2 {
    public static int countSubsets(int[] arr, int sum) {
        int len = arr.length;
        // using tablulation approach (bottom-up)
        int[][] dp = new int[len + 1][sum + 1];
        // filling out base case when sum is 0, result is 1
        // & when arr length is 0 result is 0
        for (int i = 0; i <= len; i++)
            dp[i][0] = 1;
        for (int j = 1; j <= sum; j++)
            dp[0][j] = 0;
        // now filling rest of the entries using the same recrusion logic only thing we
        // need to take care of is index of j which should be greater than arr[i-1]
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i - 1]) {
                    // then we don't include the element in the sum
                    dp[i][j] = dp[i - 1][j];// means we just reduce the size by 1
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[len][sum];
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 1, 9 };
        int sum = 8;

        System.out.println("The total number of subset that can make a sum of " + sum + " is: "
                + countSubsets(arr, sum));
    }
}
