import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Day91PathSumIII {
    int count = 0, k;
    Map<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0L);
        return count;
    }

    private void preorder(TreeNode node, long currSum) {
        if (node == null)
            return;

        // the current prefix sum
        currSum += node.val;

        // here is the sum we're looking for
        if (currSum == k)
            count++;

        // the number of times the curr_sum - k has occured already, determined
        // the number of times a path with sum k has occured up to the current node
        count += map.getOrDefault(currSum - k, 0);

        // add the current sum into the hashmap to use it during the child node's
        // processing
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // process the left subtree
        preorder(node.left, currSum);

        // process the right subtree
        preorder(node.right, currSum);

        // remove the current sum from the hasmap in order not to use it during the
        // parallel subtree processing
        map.put(currSum, map.get(currSum) - 1);
    }

    public static void main(String[] args) {
        // Creating a tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Day91PathSumIII solution = new Day91PathSumIII();

        System.out.println("The number of paths with the target sum is: " + solution.pathSum(root, 10));
    }
}
