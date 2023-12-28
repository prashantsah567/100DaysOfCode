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

public class Day46MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
       if(root == null) return 0;//base case when root is null

        int left = maxDepth(root.left);//to store the depth of left node
        int right = maxDepth(root.right);//to store the depth of right node
       return Math.max(left, right) + 1;//maximum depth will be max of left and right +1
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(maxDepth(root));
    }
}
