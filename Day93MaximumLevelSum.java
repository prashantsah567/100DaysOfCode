import java.util.*;

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

public class Day93MaximumLevelSum {
    public static int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int ans = 0, level = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Traverse the tree level by level (BFS)
        while (!q.isEmpty()) {
            level++;
            int currSum = 0;

            // iterate over all the element in the current level
            int qSize = q.size();// get the size of current queue
            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();
                currSum += node.val;
                // add the left and right child of current node if not null
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            // update the maxSum and ans based on the currSum
            if (currSum > maxSum) {
                maxSum = currSum;
                ans = level;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // creating a Binary Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("The maximum sum is at level: " + maxLevelSum(root));
    }
}
