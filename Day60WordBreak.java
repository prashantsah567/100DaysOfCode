import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day60WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        //define a hashset to store the list for quick lookup
        Set<String> wordDistSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];//boolean array to store dp result
        dp[0] = true;//first value is true as empty string result is true

        //use a nested loop to check each substring and their matching in wordDict
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                //dp[j] checks if the word break is valid and second condition check if its present in the dictionary
                if(dp[j] && wordDistSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];//last value in the dp array is our result
    }

    public static void main(String[] args){
        String s = "audioandvideo";
        List<String> wordDict = List.of("audio", "or", "video", "and");

        System.out.println(wordBreak(s, wordDict));
    }
}
