public class Day13TwoSum {
    public static void main(String[] args){
        int[] numbers = {2,7,11,14,15,19};
        int target = 9;
        int[] result = twoSum(numbers, target);

        for(int x: result)
            System.out.print(x+" ");
    }
    public static int[] twoSum(int[] numbers, int target) {
        //two pointer approach using start and end index
        int start = 0, end = numbers.length-1;
        //to store the final result which we need to return
        int[] result = new int[2];

        //loop that goes from start to end
        while(start < end){
            //since the array is sorted we can compare 
            //the target value minus first value with the last value
            if((target - numbers[start]) > numbers[end]){
                start++;
            }else if((target - numbers[start]) < numbers[end]){
                end--;
            }else{
                //if both above condition doesn't satisfy that means we got the target value
                //since our array is 1 based index we add 1 to our results
                result[0] = start+1;
                result[1] = end+1;
                break;
            }
        }
        return result;
    }
}
