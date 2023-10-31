public class Day13IntegerToRoman {
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for(int i=0; i<values.length && num>0; i++){
            //keep repeating until num is greater than current value
            while(values[i] <= num){
                num -= values[i]; //substract current value from num
                result.append(symbols[i]); //append the roman symbol to result
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        System.out.print(intToRoman(1894));
    }
}
