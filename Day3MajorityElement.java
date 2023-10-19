import java.util.Arrays;

public class Day3MajorityElement {
    public static void main(String[] args){
        int[] nums = {3,1,2,3,2,3,4,3};
        System.out.print(nums[majorityElement(nums)]);
    }
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        //majority element always appears in the middle after sorting
        return nums[nums.length/2]; 
    }
}
