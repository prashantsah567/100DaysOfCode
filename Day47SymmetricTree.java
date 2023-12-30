public class Day47SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;//base case to check if root is null
        //method that compares left and right subtree as if they are mirror of themselves
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right){
        //check if both left and right are null (means they are equal) or not null (not equal)
        if(left == null && right == null) return true;
        else if(left == null || right == null) return false;
        //check left and right values & if subtrees are mirror of each others
        return (left.val == right.val) 
        && isMirror(left.left , right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }
}
