public class Day5JumpGame {
    public static void main(String[] args){
        int[] nums = {5, 3, 4, 2, 0, 0, 1};
        System.out.print(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        //here we initialize a vaiable reachable with 0 that will be used to store value
        //of how far we can jump from an index
        int reachable = 0;
        //using a loop that will go from beginning to the end
        for(int i=0; i<len; i++){
            //each time we check if the reachable is less than the current index 
            //that means we cannot make any further jump and return false
            if(reachable < i)
                return false;
            //and each time we update the reachable if the current index + the value at 
            //the current index becomes greater than previously recorded reachable value
            reachable = Math.max(reachable, i+nums[i]);
        }
        //if the loop ends that means we are able to jump to the end and then we return true
        return true;
    }
}
