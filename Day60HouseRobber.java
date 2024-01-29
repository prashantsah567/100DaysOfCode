public class Day60HouseRobber {
    public static int rob(int[] nums) {

        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[] dp = new int[n];//dp array of size nums
        //initialize the first and second value for the dp array
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //using for loop to calculate the maximum money that can be robbed until ith house
        for(int i=2; i<n; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        //result is the maximum of last two element in the dp
        return Math.max(dp[n-1], dp[n-2]);
    }

    public static void main(String[] args){
        int[] nums = {4, 5, 10, 11, 15, 20, 7, 0};

        System.out.println(rob(nums));
    }
}
