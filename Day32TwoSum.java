//Q1. Two Sum

import java.util.HashMap;
import java.util.Map;

public class Day32TwoSum {
    public static void main(String[] args){
        int[] nums = {2, 4, 0, 6, 9, 15};
        int target = 15;
        int[] result = twoSum(nums, target);

        for(int x: result){
            System.out.print(x + " ");
        }    
    }
    public static int[] twoSum(int[] nums, int target) {
    //hashmap to sotre the nums element as key and its index as value
      Map<Integer, Integer> hm = new HashMap<>();

      for(int i=0; i<nums.length; i++){
          int temp = target - nums[i]; //difference of target and current element which is the second element
          if(hm.containsKey(temp)){//look for the second element in the hashmap
              return new int[] {hm.get(temp), i};//if present, return its value (which is its index) and current index
          }
          hm.put(nums[i], i);//if not, add the current element and its index to hashmap
      }

      return null;//if no match found return null
    }
}
