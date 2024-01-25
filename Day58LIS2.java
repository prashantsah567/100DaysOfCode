import java.util.ArrayList;
import java.util.List;

public class Day58LIS2 {
    public static int lengthOfLIS(int[] nums) {
        if(nums.length < 1) return 0;//edge case when input is empty
        //using tail list to store the minimum possible tail values for LIS 
        List<Integer> tail = new ArrayList<>();

        tail.add(nums[0]);//initialize the first value in the tail list with the first num value
        //use a loop that goes from start+1 to end of the nums array
        for(int i=1; i < nums.length; i++){
            //if the current array element is greater than last element in list, then simply we append to the list
            if(nums[i] > tail.get(tail.size()-1)){
                tail.add(nums[i]);
            }else{//else we find the index of ceiling and replace it with the current element
                int cIndex = findCeiling(tail, 0, tail.size()-1, nums[i]);
                tail.set(cIndex, nums[i]);//replace the ceiling value with the current value
            }
        }
        return tail.size();//size of tail list is our result
    }
    //this method will return the ceiling index
    private static int findCeiling(List<Integer> tail, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(tail.get(mid) < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args){
        int[] input = {1, 5, 0, 2, 3, 8, 2, 0, 9};

        System.out.println(lengthOfLIS(input));
    }
}
