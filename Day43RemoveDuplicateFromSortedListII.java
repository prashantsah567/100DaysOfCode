class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Day43RemoveDuplicateFromSortedListII {
    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next.next = new ListNode(5);

        ListNode result = deleteDuplicates(list1);

        while(result != null){
            System.out.print(result.val+ "->");
            result = result.next;
        }
        System.out.print("null");
    }
    public static ListNode deleteDuplicates(ListNode head) {
        //define a dummy node that points to head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //a curr node that points to dummy just in case we need to remove head
        ListNode curr = dummy;
        while(curr.next != null){//loop that goes until end
        //check if curr.next and its next are equal then create a temp node that goes through all the duplicate nodes
            if(curr.next.next != null && curr.next.val == curr.next.next.val){
                ListNode temp = curr.next;
                //inner loop that that check if current and its next and current next and its next are equal
                while((temp.next != null && temp.val == temp.next.val) || 
                (temp.next !=null && temp.next.next != null && temp.next.val == temp.next.next.val)){
                    temp = temp.next;
                }
                curr.next = temp.next;//this will skip all the repeated nodes
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;//finally we return the head
    }
}
