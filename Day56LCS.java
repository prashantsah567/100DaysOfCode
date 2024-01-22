import java.util.Arrays;

public class Day56LCS {
    private static int[][] memo;//declare an instance 2D array to store the repeated result
    public static int longestSubsequence(String s1, String s2){
        //initialize an array
        memo = new int[s1.length() + 1][s2.length() +1];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }

       return lcs(s1, s2, s1.length(), s2.length());
    }

    private static int lcs(String s1, String s2, int s1Size, int s2Size){

        //check if value is already computed and present in memo array
        if(memo[s1Size][s2Size] != -1){
            return memo[s1Size][s2Size];
        }
        //check for base case where either string size is 0
        if(s1Size == 0 || s2Size == 0) memo[s1Size][s2Size] = 0;
        else{
            if(s1.charAt(s1Size-1) == s2.charAt(s2Size-1)){
                memo[s1Size][s2Size] = 1+lcs(s1, s2, s1Size-1, s2Size-1);
            }else{
                memo[s1Size][s2Size] = Math.max(lcs(s1, s2, s1Size-1, s2Size), lcs(s1, s2, s1Size, s2Size-1));
            }
        }
        return memo[s1Size][s2Size];
    }
    public static void main(String[] args){
        String s1 = "abcxyz";
        String s2 = "defax";

        System.out.println("The longest subsequence is of size: " + longestSubsequence(s1, s2));
    }
}
