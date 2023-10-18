public class Day2RemoveDuplicatesFromSortedArray {
    public static void main(String[] args){
        int[] nums = {2,3,3,4,5,5};
        int result = removeDuplicates(nums);

        for(int i=0; i<result; i++){
            System.out.print(nums[i]+" ");
        }  
    }
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int insertIndex = 1; // to keep track of unique element starting at one
        for(int i=1; i < len; i++){
            //if the current element is not equals to previous element
            // we update the nums with index and also increament the index by 1
            if(nums[i] != nums[i-1]){
                nums[insertIndex++] = nums[i];
            }    
        }
        return insertIndex;
    }
}
