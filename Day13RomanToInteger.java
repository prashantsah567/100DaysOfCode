import java.util.HashMap;
import java.util.Map;

public class Day13RomanToInteger {
    static Map<String, Integer> values = new HashMap<>();
    static{
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    public static int romanToInt(String s) {
        int sum = 0, i=0;
        while(i < s.length()){
            //first we need to check if the next two symbols are accessible 
            if(i < s.length()-1){
                String doubleSymbol = s.substring(i, i+2);
                //then check if they exists in our hashmap if yes we add the value to sum
                //and increament i by 2 and ignore the rest steps
                if(values.containsKey(doubleSymbol)){
                    sum += values.get(doubleSymbol);
                    i+=2;
                    continue;
                }
            }
            String singleSymbol = s.substring(i,i+1);
            sum += values.get(singleSymbol);
            i++;
        }
        return sum;
    }

    public static void main(String[] args){
        String s = "MCMXCIV";
        System.out.print(romanToInt(s));
    }
}
