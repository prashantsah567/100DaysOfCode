public class Day38MergeTwoSortedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // Testing the hasCycle method
        ListNode result = mergeTwoLists(list1, list2);

        while(result != null){
            System.out.print(result.val+ " ");
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //base cases
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        //to keep track of new merged sorted list
        ListNode head = new ListNode();
        ListNode tail = head;
        //while eith list1 or list2 becomes null, we keep updating 
        //tail based on the values of list1 and list2, also need to update both list accordingly
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        //for remaining element in either list1 or list2
        tail.next = (list1 == null) ? list2 : list1;
        //result will be head.next as head is pointing to empty node
        return head.next;
    }
}
