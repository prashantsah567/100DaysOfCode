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

public class Day94DeleteNodeInBST {

    // delete a node in BST
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;// base case when root is null

        if (key < root.val) // if key is less than root, go to left subtree
            root.left = deleteNode(root.left, key); // link the returned value to root using root.left
        else if (key > root.val) // if key is greater than root, go to right subtree
            root.right = deleteNode(root.right, key); // link the returned value to root using root.right
        else { // this is the case when we found the key
            if (root.left == null)
                return root.right; // if left is null simply return right subtree
            else if (root.right == null)
                return root.left; // if right is null simply return left subtree

            // if the key have both left and right subtree then set the root value to
            // mininum value from right subtree
            root.val = minValue(root.right);
            // recursively call the for the right subtree as we have to delete the copied
            // minimum value from right
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    // method to find min value
    private int minValue(TreeNode root) {
        int minV = root.val;
        while (root.left != null) {
            minV = root.left.val;
            root = root.left;
        }
        return minV;
    }

    public static void main(String[] args) {
        Day94DeleteNodeInBST solution = new Day94DeleteNodeInBST();

        // Example BST: [5,3,6,2,4,null,7]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        // Print original tree
        System.out.println("Original BST:");
        printTree(root);

        // Delete node with value 3
        int keyToDelete = 3;
        root = solution.deleteNode(root, keyToDelete);

        // Print tree after deletion
        System.out.println("\nBST after deleting node with key " + keyToDelete + ":");
        printTree(root);
    }

    // Helper method to print the tree (in-order traversal)
    private static void printTree(TreeNode node) {
        if (node == null)
            return;
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }
}
