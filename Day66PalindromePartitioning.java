//1. recrusive approach
public class Day66PalindromePartitioning {
    public static int countMinPartitioning(String str, int i, int j) {
        if (isPalindrome(str, i, j))
            return 0;
        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {// making two partition each time from i-k and k+1-j
            res = Math.min(res, 1 + countMinPartitioning(str, i, k) + countMinPartitioning(str, k + 1, j));
        }
        return res;
    }

    // checking for palindrome
    private static boolean isPalindrome(String s, int start, int end) {
        if (s.length() <= 1)
            return true;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "geek";
        System.out.println("The minimum number of partition we need to make \"" + str + "\" a palindrome is: "
                + countMinPartitioning(str, 0, str.length() - 1));
    }
}
