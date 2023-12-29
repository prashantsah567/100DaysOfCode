class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Day46InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return root;//base case that checks if root is null
        //swap the left and right children
        TreeNode temp= root.left;
        root.left = root.right;
        root.right = temp;
        //recursively invert the left and right subtree
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        printInOrder(invertTree(root));
    }
    //to print the result
    private static void printInOrder(TreeNode root){
        if(root != null){
            printInOrder(root.left);
            System.out.print(root.val+ " ");
            printInOrder(root.right);
        }
    }
}
