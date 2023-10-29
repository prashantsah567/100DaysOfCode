public class Day12isSubsequence {
    public static void main(String[] args){
        String s = "abc", t = "ahbgdc";
        boolean result = isSubsequence(s,t);
        if(result) System.out.print("is a subsequence");
        else System.out.print("is not a subsequence");
    }
    public static boolean isSubsequence(String s, String t) {
        int i=0,j=0; //start a pointer from the beginning of both strings
        while(i < s.length() && j < t.length()){
            //if the character matches from s string then we increment i
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            //and we increment j in all the condition
            j++;
        }
        //if i reaches the end we return true by comparing with length of s
        return (i == s.length());
    }
}
