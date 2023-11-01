public class Day14MinimumSizeSubArraySum {
    public static void main(String[] args){
        int[] nums = {2,3,4,0,1,2,6,8};
        int target = 8;
        System.out.print(minSubArrayLen(target, nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        //using window sliding technique with two pointers
        //initializing first pointer, second pointer and sum as 0
        int first = 0, second = 0, sum=0;   
        int minLength = Integer.MAX_VALUE; //declaring the minLength as maximum int value

        while(second < nums.length){ //run a loop until second pointer reaches the end
            sum += nums[second];
            if(sum >= target){
                //then we compress the window from left side using our first pointer
                while(sum >= target){
                    sum -= nums[first];
                    first++;
                }
                //when the sum becomes less than target then we update the minLength
                //comparing itself with (second - first pointer + 2) -> (+1 for 0 based indexing 
                //and +1 to include the previous element as the sum is now less than target)
                minLength = Math.min(minLength, second-first+2);
            }
            second++; //after the if condition ends we increment the second pointer
        }
        //return 0 if minLength is still max_value (this means we don't found any solution')
        //otherwise return the updated value
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
