import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day53FindingLargestInEachRow {
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();//to store the final result

        if(root == null) return result;//base case that check if root is null

        Queue<TreeNode> q = new LinkedList<>();//define a queue that stores the TreeNodes at one level
        q.add(root);//add the root node to queue as its the only node in the first row
        
        while(!q.isEmpty()){//loop until queue is empty
            int rowSize = q.size();
            int currMax = Integer.MIN_VALUE;//set current Max to minium integer value

            for(int i=0; i<rowSize; i++){//inner loop that runs for current size of queue which is current row
                TreeNode curr = q.poll();//takes out the first element from the queue
                currMax = Math.max(currMax, curr.val);//compare previous maximum with current value
                //if current left and right are not null, append them to queue
                if(curr.left != null){ 
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            result.add(currMax);//add current maximum for one (current) row to the result
        }

        return result;//finally return the result
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(largestValues(root));
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
