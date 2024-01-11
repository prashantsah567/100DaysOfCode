public class Day52SumRootToLeaf {

    public static int sumNumbers(TreeNode root){
        if(root == null) return 0;
        return sumRootToLeaf(root, 0);
    }
    private static int sumRootToLeaf(TreeNode root, int currentSum){
        if(root == null) return 0;

        currentSum = currentSum * 10 + root.val;
        if(root.left == null && root.right == null) return currentSum;

        return sumRootToLeaf(root.left, currentSum) + sumRootToLeaf(root.right, currentSum);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(sumNumbers(root));
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
