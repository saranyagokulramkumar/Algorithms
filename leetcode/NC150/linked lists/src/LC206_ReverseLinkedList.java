/*
**Approaches**
1. Iterative
*  Use a previous pointer = null
*  while the list is not empty, rearrange the pointers tempNext = curr.next, curr.next = prev (reverse), prev = curr, curr = tempNext (next element to process)
*  return prev

*Time complexity* - O(N)
*Space complexity* - O(1)

2. Recursive
*  base case - if head is null or head.next is null return head
*  point curr to recursivecall(head.next)
*  assign head.next.next = head and head.next= null
*  return curr

*Time complexity* - O(N)
 *Space complexity* - O(1)

 */
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
