import java.util.HashMap;
import java.util.Map;

public class Day27RansomNote {
    public static void main(String[] args){
        String ransomNote = "abcdefabc", magazine = "abcdefghijabclmn";

        System.out.print(canConstruct(ransomNote, magazine));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {

        Map <Character, Integer> magazineCharVals = new HashMap<>();
        for(char x: magazine.toCharArray()){
            magazineCharVals.put(x, magazineCharVals.getOrDefault(x, 0)+1);
        }
        for(char x: ransomNote.toCharArray()){
            if(magazineCharVals.containsKey(x)){
                if(magazineCharVals.get(x) > 0){
                    magazineCharVals.put(x,magazineCharVals.get(x)-1);
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
