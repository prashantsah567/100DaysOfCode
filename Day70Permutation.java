import java.util.ArrayList;
import java.util.List;

public class Day70Permutation {
    static List<List<Integer>> res = new ArrayList<>();// to store the final result
    static List<Integer> currRes = new ArrayList<>();// to store the sub-list within the result

    public static List<List<Integer>> permute(int[] nums) {
        if (currRes.size() == nums.length) {// base case when size of nums equals list size
            res.add(new ArrayList<>(currRes)); // Add a copy of currRes
            return res;
        }

        for (int num : nums) {
            if (currRes.contains(num)) {
                continue;// if the number is already present then skip it to prevent duplicates
            }
            currRes.add(num);
            permute(nums); // Recursively permute
            currRes.remove(currRes.size() - 1); // backtrack by removing the last element
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 5, 6 };

        System.out.println(permute(nums));
    }
}
