//2. dp approach
public class Day66PalindromePartitioning_2 {
    public static int countMinPartitioning(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];// to store the result which is minimum cuts required for substring s[i..j]
        boolean[][] isPal = new boolean[n][n];// boolean array to optimize the call of isPalindrome method each time

        // filling the base case entry where i and j are equal
        // that means they are palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
            isPal[i][i] = true;
        }
        // filling rest of the entries diagonally
        // and considering only the case where i < j
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                if (str.charAt(i) == str.charAt(j) && (isPal[i + 1][j - 1] || gap == 1)) {
                    dp[i][j] = 0;
                    isPal[i][j] = true;
                } else {
                    isPal[i][j] = false;
                    dp[i][j] = Integer.MAX_VALUE;
                    // loop to fill the entries in the 2D array using the same logic as recrusion
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String str = "geek";
        System.out.println("The minimum number of partition we need to make \"" + str + "\" a palindrome is: "
                + countMinPartitioning(str));
    }
}
