import java.util.ArrayList;
import java.util.List;

public class Day34SummaryRanges {
    public static void main(String[] args){
        int[] nums = {0,1,2,4,5,7};
        
        List<String> result = summaryRanges(nums);
        System.out.println(result);
    }
    public static List<String> summaryRanges(int[] nums) {
        //list to store the result
        List<String> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            //initialize the start and end value as the current index value
            int startVal = nums[i];
            int endVal = nums[i];
            //check if there is a consecutive sequence of numbers
            //note the order of conditions to avoid indexOutOfBoundException
            while(i < nums.length-1 && nums[i]+1 == nums[i+1]){
                endVal= nums[i+1]; //update the end Value
                i++; //and increment the i each time
            }
            
            if(startVal == endVal){//if start and end value is same that means there is no range and just add a single number
                result.add(String.valueOf(startVal));
            }else{//otherwise, add the start and end value with -> sign in between
                result.add(String.valueOf(startVal)+"->"+String.valueOf(endVal));
            }
        }
        return result;//return the list
    }
}
