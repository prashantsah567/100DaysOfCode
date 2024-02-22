import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day70CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();// list to store final result
        // sort the array to only iterate through element that are greater or equal to
        // the current element
        Arrays.sort(candidates);
        backtrackCombinationSum(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private static void backtrackCombinationSum(List<List<Integer>> res, List<Integer> currRes, int[] candidates,
            int target, int start) {
        if (target == 0) {// track the target if its 0, add currRes list to the res list
            res.add(new ArrayList<>(currRes));
            return;
        } else if (target < 0) {// if target becomes less than target simply return
            return;
        }
        // a loop that goes from start - 0 to length of candidates array
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target)
                break;// stop iteration if current candidate is greater than target
            currRes.add(candidates[i]);
            // recursive call to reduce the target by current value of candidates array
            // passing i as it is to allow using the same value again and again
            backtrackCombinationSum(res, currRes, candidates, target - candidates[i], i);
            currRes.remove(currRes.size() - 1);// backtrack by removing the last element
        }
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 7, 3, 4, 5, 8 };
        int target = 7;

        System.out.println(combinationSum(candidates, target));
    }
}
