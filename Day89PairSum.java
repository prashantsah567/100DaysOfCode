class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Day89PairSum {

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(6);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Print the original list
        System.out.println("Original List:");
        printList(head);

        // Print the result
        System.out.println("\nThe maximum value of pair sum is: " + pairSum(head));
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static int pairSum(ListNode head) {

        // use slow and fast pointer to find out the middle element
        ListNode slow = head, fast = head;

        // when fast pointer reaches the end, slow pointer will be in the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of the list
        ListNode nextNode, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        // now set one pointer to start and `prev` will be the middle
        ListNode start = head;
        int result = 0;

        // move both pointer one step at a time and update result only if its greater
        // than previous value
        while (prev != null) {
            result = Math.max(result, start.val + prev.val);
            start = start.next;
            prev = prev.next;
        }

        return result;
    }
}
