//Q1. Contains Duplicate II

import java.util.HashMap;
import java.util.Map;

public class Day33ContainsNearbyDuplicates {
    public static void main(String[] args){
        int[] nums = {4, 5, 1, 0, 8, 3, 8, 7, 2};
        int k = 2; 

        System.out.print(containsNearbyDuplicate(nums, k));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //define a hashmap that store the nums element as key and their indexes as values
        Map<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
          //check if the hashmap has the current value, if yes then check the difference of the indices
          if(hm.containsKey(nums[i])){
            if(i - hm.get(nums[i]) <= k) return true;
          }
          hm.put(nums[i], i);
        }
        return false;
    }
}
