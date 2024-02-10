//2. Efficient solution using Catalan Numbers to count the total BST arrangements with N keys
public class day64CountBSTWithNkeys_2 {
    public static double countBST(int n) {
        // this solution is based on Catalan number formula which is
        // (2n!/(n+1)!n!)
        return ((double) fac(2 * n)) / ((fac(n + 1)) * fac(n));
    }

    // calculating the factorial
    private static long fac(int n) {
        if (n <= 1)
            return 1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int numberOfKeys = 5;
        System.out.println(
                "The total BST that can be generated with " + numberOfKeys +
                        " keys is: " + (long) countBST(numberOfKeys));
    }
}
