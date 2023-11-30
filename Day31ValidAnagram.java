//Q2. Valid Anagram
import java.util.LinkedHashMap;
import java.util.Map;

public class Day31ValidAnagram {

    public static void main(String[] args){
        String s = "anagram", t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        //base case to check if both strings are of same size
        if(s.length() != t.length()) return false;

        //hashmaps to store the key-value pairs where character is the key and it's repeatition is the value
        //here we used LinkedHashMap so that the key-value insertion will be sorted by default
        Map<Character, Integer> s_hm = new LinkedHashMap<>();
        Map<Character, Integer> t_hm = new LinkedHashMap<>();

        for(int i=0; i<s.length(); i++){
            s_hm.put(s.charAt(i), s_hm.getOrDefault(s.charAt(i),0)+1);
            t_hm.put(t.charAt(i), t_hm.getOrDefault(t.charAt(i),0)+1);
        }

        return s_hm.equals(t_hm); //this compares the two hashmaps if they are equal or not
    }
}
