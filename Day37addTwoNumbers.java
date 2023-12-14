public class Day37addTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Testing the hasCycle method
        ListNode result = addTwoNumbers(l1, l2);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(0);//to hold the previous of head
        ListNode current = tempHead;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int l1Num = (l1 != null) ? l1.val : 0;
            int l2Num = (l2 != null) ? l2.val : 0;

            int sum = l1Num + l2Num + carry;
            carry = sum / 10;
            current.next = new ListNode(sum%10); //because we only allowed to store a digit from 0 - 9
            
            current = current.next;
            //check if l1 or l2 is already null
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return tempHead.next; //return the head
    }
}
