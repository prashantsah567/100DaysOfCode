import java.util.HashSet;
import java.util.Set;

public class Day33LongestConsecutiveSequence {
    public static void main(String[] args){
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.print(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        //store the array element into a HashSet, this will sort the element by default
        Set<Integer> hs = new HashSet<>();
        for(int num: nums){
          hs.add(num);
        }

        int longestStreak = 0;
        //loop through the hash set
        for(int num: hs){
          //proceed only if there is no previous value for the current element because it's already counted
          if(!hs.contains(num-1)){
            int currentNum = num;
            int currentStreak = 1;
            //another loop that counts the longest streak
            while(hs.contains(currentNum+1)){
              currentNum += 1;
              currentStreak += 1;
            }
            //update the streak comparing with current and previous streak
            longestStreak = Math.max(longestStreak, currentStreak);
          }
        }
        return longestStreak;
    }
}
