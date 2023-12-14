public class Day37DetectCycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args){
        ListNode list = new ListNode(2);
        list.next = new ListNode(4);
        list.next.next = new ListNode(3);
        list.next.next.next = list.next;

        // Testing the hasCycle method
        System.out.println("Cycle Detected: " + hasCycle(list));
    }
    //method implementation
    public static boolean hasCycle(ListNode head) {

        if(head == null) return false;
        //using two pointers slow and fast
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
        return false;
    }

}
