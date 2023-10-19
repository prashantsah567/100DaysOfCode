public class Day3RotateArray {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        int k=3;
        rotate(nums, k);

        for(int num: nums){
            System.out.print(num+" ");
        }
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // to handle k if its greater than array length
        
        //now using the reverse approach
        reverse(nums, n-k, n-1); //first we reverse the last part of the array n-k to end
        reverse(nums, 0, n-k-1); //then we reverse the first part of the array from 0 to n-k-1
        reverse(nums, 0, n-1); //then we reverse the whole array from start to end
    }
    //method to reverse the elements by swapping
    public static void reverse(int nums[], int first, int last){
        while(first<last){
            // swap(nums[first], nums[last]); 
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first++;
            last--;
        }
    }
}
