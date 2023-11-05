import java.util.HashSet;
import java.util.Set;

public class Day17LongestSubstring {
    public static void main(String[] args){
        String s = "aabcdefcdejhkiac";
        System.out.print(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int first =0, second=0, maxLength=0;
        Set<Character> result = new HashSet<>();

        while(second < s.length()){
            char currentChar = s.charAt(second);
            
            if(!result.contains(currentChar)){
                result.add(currentChar);
                second++;
                maxLength = Math.max(maxLength, result.size());
            }else{
                result.remove(s.charAt(first));
                first++;
            }
        }
        return maxLength;
    }
}
