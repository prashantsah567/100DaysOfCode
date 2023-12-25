class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Day44RotateList {
    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        ListNode result = rotateRight(list1, 2);

        while(result != null){
            System.out.print(result.val+ "->");
            result = result.next;
        }
        System.out.print("null");
    }
    public static ListNode rotateRight(ListNode head, int k) {
        //if head is null or head.next is null return head
        if(head == null || head.next == null) return head;

        //to find the size
        ListNode curr = head;
        int size=1;
        while(curr.next != null){
            size++;
            curr = curr.next;
        }
        k = k%size;//incase k value is greater than size

        if(k == 0) return head;//no rotation needed

        curr.next = head; //connect the tail to head to make the list circular

        int stepsToRotate = size - k;
        while(stepsToRotate > 0){
            curr = curr.next;
            stepsToRotate--;
        }
        ListNode newHead = curr.next;//next of current is our new head after size-k rotation
        curr.next = null;//break the circle
        
        return newHead;
    }
}
