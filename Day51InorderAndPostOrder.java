import java.util.HashMap;
import java.util.Map;

public class Day51InorderAndPostOrder {

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

    private static int postOrderIndex;
    private static Map<Integer, Integer> inorderIndexMap;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length-1;
        inorderIndexMap = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }
        return constructBTree(postorder, 0, inorder.length-1);
    }

    private static TreeNode constructBTree(int[] postorder, int startIndex, int endIndex){
        if(startIndex > endIndex) return null;

        TreeNode root = new TreeNode(postorder[postOrderIndex--]);

        root.right = constructBTree(postorder, inorderIndexMap.get(root.val) + 1, endIndex);
        root.left = constructBTree(postorder, startIndex, inorderIndexMap.get(root.val) - 1);

        return root;
    }

    public static void main(String[] args){
        int[] postorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(inorder, postorder);

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
