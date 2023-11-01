public class Day15ContainerWithMostWater {

    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.print(maxArea(height));
    }

    public static int maxArea(int[] height) {
        //two pointers one from start another from end
       int first = 0, last = height.length-1;
       int res = Integer.MIN_VALUE; //to store the final result we set the res variable as min value

       while(first < last){
           //first we find a minimum of first and last height that can hold the water
           int maxHeightforWater = Math.min(height[first], height[last]);
           //then we store the current maximum value by multiplying the (last pointer - first pointer)
           //with the maximum height of water that can be held
           int currMax = (last-first) * maxHeightforWater;
           //we update the res variable only if currMax is greater than res
           res = Math.max(res, currMax);
           //we move one step from first or last depening on their height
           if(height[first]>height[last]) last--;
           else first++;
       } 
       return res;
    }
}
