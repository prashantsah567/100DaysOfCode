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

public class Day55CountCompleteTreeNodes {
    public static int countNodes(TreeNode root) {
        //calculate height of left and right subtree
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        //if left and right have same tree that means its a perfect Binary Tree, and number of nodes is 2^height -1
        if(leftHeight == rightHeight) return (1 << leftHeight) - 1;
        //otherwise we add 1 to the returned value of left and right subtree
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }
    //calculating the left height
    private static int leftHeight(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    }
    //calculating the right height
    private static int rightHeight(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.right;
        }
        return height;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println("Total nodes in the given tree is: "+ countNodes(root));
    }
}
