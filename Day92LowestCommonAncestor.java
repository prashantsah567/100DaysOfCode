class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Day92LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If the root is null or matches either p or q, return the root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Check the left subtree for the LCA
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Check the right subtree for the LCA
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are not null, it means p and q are on different sides
        // of the current root, so the LCA is the root
        if (left != null && right != null) {
            return root;
        }

        // If either left or right is not null, it means one of p or q is an ancestor
        // of the other, so return the non-null node
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        // Creating a binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(7);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(8);

        TreeNode p = root.right.left, q = root.right.right.right;

        Day92LowestCommonAncestor solution = new Day92LowestCommonAncestor();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        System.out.println("Lowest common Ancestor for : " + p.val + " and " + q.val + " is: "
                + lca.val);
    }
}
