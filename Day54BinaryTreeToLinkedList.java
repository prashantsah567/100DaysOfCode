class TreeNode{//defining the tree structure
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

public class Day54BinaryTreeToLinkedList {


    static TreeNode prev;//instance variable to store the prev element
    public static void flatten(TreeNode root) {
        prev = null;
        preorder(root);//implement a method with the root as the head of linked list
    }
    private static void preorder(TreeNode curr){
        if(curr == null) return;//base case when curr becomes null we simply return
        if(prev != null){ //if prev is not null then we set it's left as null and right as curr
            prev.left = null;
            prev.right = curr;
        }
        //since we changing the right reference, we need to store the rightsubtree into another variable (pointer)
        TreeNode rightSubTree = curr.right;
        prev = curr;//and finally we can set the prev as curr
        preorder(curr.left);//pass the left element in the recursion
        preorder(rightSubTree);//when done with left tree, we do the recursion for right subtree
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        flatten(root);

        while(root != null){
            System.out.print(root.val+ " ");
            root = root.right;
        }
    }
}
