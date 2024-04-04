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

// Count Good Nodes in a Given Binary Tree
public class CountGoodNodes {

    private int numGoodNodes = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }

    // helper method that do a dfs traversal while keeping track of max value so far
    private void dfs(TreeNode node, int maxSoFar) {
        if (maxSoFar <= node.val) {// condition where we increment the good nodes count
            numGoodNodes++;
        }

        if (node.right != null) {
            dfs(node.right, Math.max(node.val, maxSoFar));
        }

        if (node.left != null) {
            dfs(node.left, Math.max(node.val, maxSoFar));
        }
    }

    public static void main(String[] args) {
        // Creating a binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        // Creating an instance of CountGoodNodes
        CountGoodNodes solution = new CountGoodNodes();

        // Testing the goodNodes method
        int goodNodesCount = solution.goodNodes(root);
        System.out.println("Number of good nodes: " + goodNodesCount);
    }

}
