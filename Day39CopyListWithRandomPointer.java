import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Day39CopyListWithRandomPointer {
    public static Node copyRandomList(Node head) {
        if(head == null) return null;

        //Map to store the mapping between original nodes and their copies
        Map<Node, Node> nodeMap = new HashMap<>();
        //first pass: create a copy of each node without setting random pointers
        Node curr = head;
        while(curr != null){
            nodeMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        //second pass: set next and random pointers in the copied list
        curr = head;
        while(curr != null){
            nodeMap.get(curr).next = nodeMap.get(curr.next);
            nodeMap.get(curr).random = nodeMap.get(curr.random);
            curr = curr.next;
        }
        //return the head of the copied list
        return nodeMap.get(head);
    }

    public static void main(String[] args){
        //create a linked list with random pointers
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3;
        node2.random = node1;
        node3.random = node2;

        Node resultList = copyRandomList(node1);
        //print the result
        while (resultList != null) {
            System.out.print("(" + resultList.val + " , ");
            if (resultList.random != null) {
                System.out.print(resultList.random.val);
            } else {
                System.out.print("null");
            }
            System.out.print(") -> ");
            resultList = resultList.next;
        }
        System.out.println("null");
    }
}
