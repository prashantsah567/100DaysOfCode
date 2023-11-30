//Q3. Group Anagram
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day31GroupAnagram {
    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        //defining map to store strs element as key and anagram list as values
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            //computeIfAbsent method checks if the key (sortedStr) is already present then it add the str to it (existing value)
            //if not then it gonna create a new arraylist and add the str to it
            anagramGroups.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        //retrun the map value as arraylist
        return new ArrayList<>(anagramGroups.values());
    }
}
