package reverseLinkedList;

import common.ListNode;

//todo
public class reverseLinkedList {
    // iterative solution

    public ListNode reverseListIter(ListNode head) {
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
// recursive solution

    public ListNode reverseList(ListNode head) {
        return reverseListInt(head, null);
    }

    public ListNode reverseListInt(ListNode head, ListNode newHead) {
        if(head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
