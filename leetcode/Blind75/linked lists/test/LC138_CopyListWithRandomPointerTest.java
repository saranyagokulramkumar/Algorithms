//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class LC138_CopyListWithRandomPointerTest {
//
//    static LC138_CopyListWithRandomPointer solution;
//
//    @BeforeAll
//    public static void init(){
//        solution = new LC138_CopyListWithRandomPointer();
//    }
//
//    private static Node createLinkedList(int[] values){
//        if(values.length == 0)return null;
//
//        Node head = new Node(values[0]);
//        Node curr = head;
//
//        for(int i = 1; i < values.length; i++){
//            curr.next = new Node(values[i]);
//            curr
//            curr = curr.next;
//        }
//        return head;
//    }
//
//    // Method to create an array from a linked list head
//    public static int[] linkedListToArray(ListNode head){
//        List<Integer> resultList = new ArrayList<>();
//        ListNode current = head;
//        while(current != null){
//            resultList.add(current.val);
//            current = current.next;
//        }
//        return resultList.stream().mapToInt(i -> i).toArray();
//    }
//
//    @Test
//    public void testCopyListIteratively(){
//        int[] list = new int[]{1,2,3,4,5};
//        Node l1 = LinkedListUtils.createLinkedList(list);
//        Node l2 = solution.copyListIteratively(l1);
//    }
//}
