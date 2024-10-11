/*
**Approaches**
1. Iterative
*  if head is null or head.next is null return head
*  Maintain a sentinel node with -1 as the value with next pointing to head
*  Take two nodes at a time and swap and reassign previous and head pointers.
*  Return sentinel.next.

*Time complexity* - O(N)
*Space complexity* - O(1)

2. Recursive
*  base case - head is null or head.next is null, return head
*  take head as node1 and head.next as node2
*  node1.next = recursive(node2.next)
*  node2.next = node1
*  return node2

*Time complexity* - O(N)
*Space complexity* - O(1)
 */

public class LC24_SwapNodesInPairs {
    public ListNode swapPairsIterative(ListNode head) {
        if(head == null || head.next == null)return head;

        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode prev = sentinel;

        while(head != null && head.next != null){
            ListNode node1 = head;
            ListNode node2 = head.next;

            swapNodes(node1, node2, prev);
            prev = node1;
            head = node1.next;
        }

        return sentinel.next;
    }

    private void swapNodes(ListNode node1, ListNode node2, ListNode prev){
        prev.next = node2;
        node1.next = node2.next;
        node2.next = node1;
    }

    public ListNode swapPairsRecursive(ListNode head){
        if(head == null || head.next == null)return head;

        ListNode node1 = head;
        ListNode node2 = head.next;

        node1.next = swapPairsRecursive(node2.next);
        node2.next = node1;

        return node2;
    }
}
