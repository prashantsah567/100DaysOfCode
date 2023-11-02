import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day15_3Sum {
    
    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};

        System.out.print(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<>();
        //sort the element
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>(); //to store the unique result
        //Now fix the first element and find the other tow elements
        for(int i=0; i<nums.length-2; i++){
            //finding other two elements using Two sum approach
            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    //add them to set, and move to find other tirplets
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
                else if(sum < 0) left++;
                else right--;
            }
        }
        return new ArrayList<>(result);
    }
}
