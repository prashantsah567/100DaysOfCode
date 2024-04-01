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

public class Day88OddEvenList {
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the original list
        System.out.println("Original List:");
        printList(head);

        // Call oddEvenList function
        head = oddEvenList(head);

        // Print the modified list
        System.out.println("\nList after rearrangement:");
        printList(head);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static ListNode oddEvenList(ListNode head) {

        if (head == null)
            return null; // base case when head is null
        // declare three pointers odd, even, and even head; the given head will be odd
        // head
        ListNode odd = head, even = head.next, evenHead = even;

        // even != null, rules out the list of only 1 node
        // even.next != null, rules out the list of only 2 nodes
        while (even != null && even.next != null) {
            // put odd to the odd list
            odd.next = odd.next.next;

            // put even to the even list
            even.next = even.next.next;

            // move the pointer to the next odd/even
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead; // add even list to the end of odd list
        return head;
    }
}
