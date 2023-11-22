import java.util.Arrays;

public class Day27IsomorphicString {
    public static void main(String[] args){
        String s1 = "abbcd", t1 = "lmmpq";
        String s2 = "title", t2 = "peppr";

        System.out.println(isIsomorphic(s1,t1));
        System.out.println(isIsomorphic(s2, t2));
    }
    public static boolean isIsomorphic(String s, String t) {

        int[] mappingStoT = new int[256];
        Arrays.fill(mappingStoT, -1);

        int[] mappingTtoS = new int[256];
        Arrays.fill(mappingTtoS, -1);

        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            //case1: When no mapping exists in either of the array
            if(mappingStoT[c1] == -1 && mappingTtoS[c2] == -1){
                mappingStoT[c1] = c2;
                mappingTtoS[c2] = c1;
            }
            //case2: Either mapping doesn't exist in one of the dictionary or mapping exists and
            //it doesn't match in either of the dictionaries or both
            else if(!(mappingStoT[c1] == c2 && mappingTtoS[c2] == c1)){
                return false;
            }
        }
        return true;
    }
}
