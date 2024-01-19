import java.util.ArrayList;

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

public class Day55BSTIterator {
    ArrayList<Integer> nodesSorted;
    int index;

    public Day55BSTIterator(TreeNode root) {
        //this list will store all the nodes in the sorted order as we doing in-order traversal
        nodesSorted = new ArrayList<Integer>();
        index = -1;//pointer to the next smallest element in BST
        inorder(root);//method to flatten the input binary search tree
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        nodesSorted.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return nodesSorted.get(++index);//return numbers one by one with pre-increament index value
    }
    
    public boolean hasNext() {
        return index+1 < nodesSorted.size();//check if we reached end or not
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        Day55BSTIterator iterator = new Day55BSTIterator(root);

        System.out.println("BST elements in ascending order: ");
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }
}