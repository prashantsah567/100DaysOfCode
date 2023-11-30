//Q1. Word Pattern
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day31WordPattern {
    public static void main(String[] args){
        String pattern = "abba";
        String s = "dog cat cat dog";

        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        //lets split the s and store them into an array
        String[] s_arr = s.split(" ");
        //base case to match number of characters in pattern and words in s
        if(pattern.length() != s_arr.length) return false;  
        Map<Character, String> hm = new HashMap<>(); //to store key-value pair of pattern and s
        Set<String> usedWords = new HashSet<>(); //to store the usedWords

        //we storing the pattern character as key and s word as value and 
        //each time we check if the key is already there and if that's true we check for its value
        //which should be matching with the current value

        for(int i=0; i<pattern.length(); i++){
            char currentChar = pattern.charAt(i);
            String currentWord = s_arr[i];

            if(hm.containsKey(currentChar)){
                if(!hm.get(currentChar).equals(currentWord)){
                    return false;
                }    
            }else{//if we don't have the key then we shouldn't have the value as well
                if(usedWords.contains(currentWord)){
                    return false;
                }
                hm.put(currentChar, currentWord);
                usedWords.add(currentWord);
            }
        }
        return true;
    }
}
