public class Day6JumpGameII {
    public static void main(String[] args){
        int[] nums = {2,3,1,1,4};
        System.out.print(jump(nums));
    }
    public static int jump(int[] nums) {
        //lets initialize two pointers left and right as beginning index
        int left = 0, right = 0;
        //and result as 0
        int result = 0;

        //run a loop unitl our right pointer to the end of the array
        while(right < nums.length -1){
            //need to track the farthest jump that can be made
            int farthest = 0;
            //now we need to update the farthest jump we can make 
            //within the current window of left and right
            for(int i=left; i<right+1; i++){
                farthest = Math.max(farthest, i+nums[i]);
            }
            //since we have updated our farthest we can now update left and right pointer
            //more like a sliding window where we bring our left pointer to the right + 1
            //right to the farthest jump we can make
            left = right+1;
            right = farthest;
            //we also update our result each time to keep track of how many jumps we made so far
            result +=1;
        }
        return result;
    }
}
