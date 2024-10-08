public class LC206_ReverseLinkedList {
    public ListNode reverseListIterative(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head){
        if(head == null || head.next == null)return head;
        ListNode curr = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return curr;
    }
}
