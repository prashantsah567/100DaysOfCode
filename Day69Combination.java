import java.util.ArrayList;
import java.util.List;

public class Day69Combination {
    static List<List<Integer>> res = new ArrayList<>();// nested list to store the result
    static List<Integer> currentRes = new ArrayList<>();// list to store the current result of size k

    public static List<List<Integer>> combine(int n, int k) {
        // case when k is greater than n, there'll be no combination
        if (k > n)
            return res;
        backtrackCombine(1, n, k);// call the backtrack with start as 1, as we are going from 1..N
        return res;
    }

    private static void backtrackCombine(int start, int n, int k) {
        // add the current result value to res list when its size equals k,
        // means we made one successful combination
        if (currentRes.size() == k) {
            res.add(new ArrayList<>(currentRes));
            return;
        }
        // loop that goes from 1..N and each time we do a recursive call with parameter
        // start+1 and finally we backtrack by removing the last element from the list
        for (int i = start; i <= n; i++) {
            currentRes.add(i);
            backtrackCombine(i + 1, n, k);
            currentRes.remove(currentRes.size() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
