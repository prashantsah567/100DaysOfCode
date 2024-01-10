public class Day52PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum){
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == targetSum) return true;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,  - root.val);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(hasPathSum(root, 10));
    }

    public static class TreeNode{
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
}
