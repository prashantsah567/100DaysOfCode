class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Day41ReverseLinkedListII {
    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        ListNode result = reverseBetween(list1, 2, 4);

        while(result != null){
            System.out.print(result.val+ "->");
            result = result.next;
        }
        System.out.print("null");
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        //move to the node before the reversed sublist
        for(int i=1; i < left; i++){
            prev = prev.next;
        }
        //Reverse the sublist, of size (right-left+1)
        ListNode newHead = reverseSublist(prev.next, right-left+1);

        //connect the reversed sublist back to the original list
        prev.next = newHead;

        return dummy.next;//this has reference to head
    }

    public static ListNode reverseSublist(ListNode head, int k){
        ListNode curr = head, prev = null;

        for(int i = 0; i < k; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //connect the reversed sublist to the rest of the list
        head.next = curr;

        return prev;//returned as new head of reversed sublist
    }
}
