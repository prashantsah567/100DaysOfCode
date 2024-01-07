import java.util.HashMap;
import java.util.Map;

public class Day51InorderAndPreOrder {

    public static class TreeNode {
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
    //approach: construct tree using preorder (root,left,right) linear traversal 
    //and use in-order(left,root,right) to to find left and right sub-tree and for quick search we'll use HashMap
    static int preorderIndex; 
    static Map<Integer, Integer> inorderIndexMap;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0; //start from 0 index of preorder array
        inorderIndexMap = new HashMap<>();
        //store the inorder into hashmap where the element is key and index is value
        for(int i=0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }
        
        return constructTree(preorder, 0, preorder.length-1);
    }

    private static TreeNode constructTree(int[] preorder, int startIndex, int endIndex){
        if(startIndex > endIndex) return null;//if start and end index cross each other return null
        //define the root which is the first elment of preorder and then increment linearly
        TreeNode root = new TreeNode(preorder[preorderIndex++]); 
        //construct left sub-tree from startIndex to endIndex (endIndex is the index of inorder using map)
        root.left = constructTree(preorder, startIndex, inorderIndexMap.get(root.val) - 1);
        //construct right sub-tree from startIndex(startIndex is the index of inorder using map) to endIndex 
        root.right = constructTree(preorder, inorderIndexMap.get(root.val) + 1, endIndex);

        return root;//return root after recursive call ends
    }

    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);

        printTree(root);
    }

    private static void printTree(TreeNode root){
        if(root != null){
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }
}
