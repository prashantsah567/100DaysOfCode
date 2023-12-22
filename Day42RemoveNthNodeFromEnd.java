class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Day42RemoveNthNodeFromEnd {
    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        ListNode result = removeNthFromEnd(list1, 2);

        while(result != null){
            System.out.print(result.val+ "->");
            result = result.next;
        }
        System.out.print("null");
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //define a dummy node incase if head needs to be removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //declare two pointers slow and fast
        ListNode slow = dummy;
        ListNode fast = dummy;
        //move fast n+1 steps ahead
        for(int i=0; i<=n; i++){
            fast = fast.next;
        }
        //now move both slow and fast pointers util fast reaches the end
        //as when fast reaches the end slow should be pointing to previous of nth node from end
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        //remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;//return dummy.next which is head
    }
}
