class Day2RemoveElement {

    public static void main(String[] args){
        int[] nums = {3,2,4,5,3,3};
        int val = 3;
        int result = removeElement(nums, val);

        for(int i=0; i<result; i++){
            System.out.print(nums[i]+" ");
        }  
    }
    public static int removeElement(int[] nums, int val) {
        int reader = 0, writer = 0;
        //if the reader haven't reached the end we stay in the loop
        while (reader < nums.length){
            if(nums[reader] == val){
                //if we read a value which is equals to val we just increament the reader pointer
                reader++;
            }else{
                //otherwise we write the value using writer pointer and increament both the reader and writer
                nums[writer] = nums[reader];
                reader++;
                writer++;
            }
        }
        // we return the value of writer pointer because when reader reaches the end writer would be pointing to the end of all non-val values
         return writer;
    }
}