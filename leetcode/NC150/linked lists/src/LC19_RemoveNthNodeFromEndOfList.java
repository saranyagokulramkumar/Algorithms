/*
**Approaches**
1. Two pass approach
*  Find the length, L, of the linked list in one pass
*  removal_index = L - n
*  previous = head, current = head
*  start from 0 index and keep advancing until current_index < removal_index and update curr and prev pointers accordingly
*  once the indices match, prev.next = curr.next and curr = null.
*  return head

*Time complexity* - O(2L) ~ O(L)
*Space complexity* - O(1)

2. One pass approach; two pointers
*  keep two pointers
*  initialize first and second pointers to dummy
*  advance first pointer to position n in the list starting from 1
*  Now advance both second pointer starting from dummy and first pointer until first pointer reaches null; at this point second pointer is n nodes before first pointer and second.next will give us the node to delete
*  Simply change second.next to point to second.next.next
*  return dummy.next

*Time complexity* - O(L)
*Space complexity* - O(1)
 */

public class LC19_RemoveNthNodeFromEndOfList {
    public ListNode twoPassRemove(ListNode head, int n){
        if(head == null)return head;

        // find length of list
        int length = findListLength(head);
        int removal_index = length - n;

        if(removal_index == 0)return head.next;

        ListNode prev = head, curr = head;
        int current_index = 0;

        while(current_index < removal_index){
            current_index++;
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
        curr = null;

        return head;
    }

    private int findListLength(ListNode head){
        ListNode curr = head;
        int length = 0;

        while(curr != null){
            length++;
            curr = curr.next;
        }
        return length;
    }

    public ListNode onePassRemove(ListNode head, int n){
        if(head == null)return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy, second = dummy;

        for(int i = 1; i <= n + 1; i++){
            first = first.next;
        }

        while(first != null){
            first = first.next;
            second = second.next;
        }

        // now second and first are n nodes apart, delete second.next
        second.next = second.next.next;
        return dummy.next;
    }
}
