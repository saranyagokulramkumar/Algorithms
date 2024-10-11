/*
**Approaches**
1. Iterative
*  Maintain two pointers to each list and create a sentinel node, head = -1
*  Point prev node to also point to head
*  Return the other list if either of the list is empty
*  Now until either of the list is empty, compare values pointed to the pointers and assign prev.next with the smaller value, while advancing the pointer of the list which has the smaller element. At the end advance the prev pointer as well.
*  After we have exhausted either of the lists, if the other list still has elements, simply add it to the result list by pointing prev.next to the non-empty list
*  Return head.next

*Time complexity* - O(m+n)
*Space complexity* - O(1)

2. Recursive
*  base case : if either of the list is empty, return the head of the other list
*  initialize a new node head and assign l1 or l2 based on whichever is smaller, advance the list pointer as well
*  point head.next to recursive call with the new l1 & l2
*  return head at the end.

*Time complexity* - O(m+n)
*Space complexity* - O(1)

 */

public class LC21_MergeTwoSortedLists {
    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode head = new ListNode(-1);
        ListNode prev = head;

        if(ptr1 == null)return ptr2;
        if(ptr2 == null)return ptr1;

        while(ptr1 != null && ptr2 != null){
            if(ptr1.val < ptr2.val){
                prev.next = ptr1;
                ptr1 = ptr1.next;
            }else{
                prev.next = ptr2;
                ptr2 = ptr2.next;
            }
            prev = prev.next;
        }
        if(ptr1 != null){
            prev.next = ptr1;
        }

        if(ptr2 != null){
            prev.next = ptr2;
        }
        return head.next;
    }

    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2){
        if(l1 == null)return l2;
        if(l2 == null)return l1;

        ListNode head;

        if(l1.val < l2.val){
            head = l1;
            l1 = l1.next;
        }else{
            head = l2;
            l2 = l2.next;
        }

        head.next = mergeTwoListsRecursive(l1,l2);

        return head;
    }
}
