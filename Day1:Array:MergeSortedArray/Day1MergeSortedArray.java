class Day1MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {5,6,7};
        int m=3, n=3;
        merge(nums1, nums2, m, n); // calling the merge method
        //print the result
        for(int num: nums1){
            System.out.print(num+" ");
        }
    }

    public static void merge(int[] nums1, int[] nums2, int m, int n){
        int p1 = m-1; //pointer 1 to the end of element in nums1
        int p2 = n-1; //pointer 2 to the end of element in nums2
        //declaring pointer 3 to the end of nums1 which is the size of m+n
        for(int p3 = m+n-1; p3 >= 0; p3--){
            //here we start from end and go until the first element in nums1 & nums2
            if(p1 >= 0 && p2 >= 0){
                nums1[p3] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            }else if(p1 >= 0){
                //there could be a case where p2 exaushed but p1 still inside the array
                 nums1[p3] = nums1[p1--];
            }else{
                //likewise there could be a case where p1 exaushed but p2 still inside the array
                 nums1[p3] = nums2[p2--];
            }
        }
        return;
    }
}