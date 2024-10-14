/*
**Approach**
1. Find the middle of the linked list
2. Reverse the second half, break the original list into two halfs by pointing slow.next to null to avoid cycles after return slow.next as the middle
3. Merge the sorted lists together by taking one node each from the two lists at a time

*Time complexity* - O(N)
*Space complexity* - O(1)
 */
public class LC143_ReorderList {
    public void reorderList(ListNode head){

        LC206_ReverseLinkedList reverseFunction = new LC206_ReverseLinkedList();

        ListNode middle = findMiddle(head);
        ListNode reverse = reverseFunction.reverseListIterative(middle);
        mergeLists(head, reverse);
    }

    private ListNode findMiddle(ListNode head){
        ListNode slowptr = head, fastptr = head;
        while(fastptr != null && fastptr.next != null){
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
        }

        // break the list in the middle
        ListNode middle = slowptr.next;
        slowptr.next = null;

        return middle;
    }

    private void mergeLists(ListNode head, ListNode middle){
        while(middle != null){
            ListNode temp1 = head.next;
            ListNode temp2 = middle.next;

            head.next = middle;
            middle.next = temp1;

            head = temp1;
            middle = temp2;
        }
    }
}
