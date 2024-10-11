import java.util.ArrayList;
import java.util.List;

public class LinkedListUtils {
    // Method to create a linked list from an array of integers
    public static ListNode createLinkedList(int[] values){
        if(values.length == 0)return null;

        ListNode head = new ListNode(values[0]);
        ListNode curr = head;

        for(int i = 1; i < values.length; i++){
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }

    // Method to create an array from a linked list head
    public static int[] linkedListToArray(ListNode head){
        List<Integer> resultList = new ArrayList<>();
        ListNode current = head;
        while(current != null){
            resultList.add(current.val);
            current = current.next;
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}

