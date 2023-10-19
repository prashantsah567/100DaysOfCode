class Day3RemoveDuplicatesII {
    public static void main(String[] args){
        int[] nums = {2,3,3,3,4,5,5};
        int result = removeDuplicates(nums);

        for(int i=0; i<result; i++){
            System.out.print(nums[i]+" ");
        }  
    }
    public static int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        int maxRepeat = 1; //to keep track of repeated element which is atmost 2
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[insertIndex++] = nums[i];
                maxRepeat = 1; //reset the maxRepeat counter with each unique element
            }else if(nums[i] == nums[i-1] && maxRepeat < 2){
                nums[insertIndex++] = nums[i];
                maxRepeat++;
            }
        }
        return insertIndex;
    }
}