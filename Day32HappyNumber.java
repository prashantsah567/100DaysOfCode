//Q2. Happy Number

import java.util.HashSet;
import java.util.Set;

public class Day32HappyNumber {
    public static void main(String[] args){
        int n = 79;

        System.out.print(isHappy(n));
    }
    public static boolean isHappy(int n) {
        //set to sotre the all computed n's values
        Set<Integer> hs = new HashSet<>();
        //run a loop until n becomes 1
        while(n != 1){
            int sumOfSq = 0;
            //calculate the sum of square of digits
            while (n > 0){
                int digit = n%10;
                sumOfSq += digit * digit;
                n = n/10;
            }
            //check if there is a cycle 
            if(hs.contains(sumOfSq)){
                return false;
            }
            //if no cycle found, add to set
            hs.add(sumOfSq);
            n = sumOfSq;
        }
        return true; //return true if n becomes 1
    }
}
