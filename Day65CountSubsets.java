//1. Recrusive approach
public class Day65CountSubsets {
    public static int countSubsets(int[] arr, int n, int sum) {
        if (n == 0)
            return sum == 0 ? 1 : 0;
        return countSubsets(arr, n - 1, sum) + countSubsets(arr, n - 1, sum - arr[n - 1]);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 4, 6, 3 };
        int sum = 8;

        System.out.println("The total number of subset that can make a sum of " + sum + " is: "
                + countSubsets(arr, arr.length, sum));
    }
}
