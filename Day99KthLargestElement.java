import java.util.*;

public class Day99KthLargestElement {

    // finding kth largest element without sorting
    public static int findKthLargest(int[] nums, int k) {
        // Initializing the min-heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            // push element into the heap and pop when size exceeds k
            heap.add(num);
            if (heap.size() > k) {
                heap.remove(); // the smallest element will be popped
            }
        }
        // the top of the heap is the kth largest element
        return heap.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, -1, 5, 7, 11 };
        int k = 4;

        System.out.println("The " + k + "th largest element is: " + findKthLargest(nums, k));
    }
}
