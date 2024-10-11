import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LC24_SwapNodesInPairsTest {
    static LC24_SwapNodesInPairs solution;

    @BeforeAll
    public static void init(){
        solution = new LC24_SwapNodesInPairs();
    }

    private ListNode createLinkedList(int[] values){
        if(values.length == 0)return null;

        ListNode head = new ListNode(values[0]);
        ListNode curr = head;

        for(int i = 1; i < values.length; i++){
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }

        return head;
    }

    private int[] linkedListToArray(ListNode head){
        List<Integer> resultList = new ArrayList<>();
        ListNode curr = head;

        while(curr != null){
            resultList.add(curr.val);
            curr = curr.next;
        }

        return resultList.stream().mapToInt(i -> i).toArray();
    }
    @Test
    public void testSwapPairsIterative(){
        int[] values = new int[]{1,2,3,4};
        ListNode head = createLinkedList(values);
        int[] expected = new int[]{2,1,4,3};

        ListNode result = solution.swapPairsIterative(head);
        int[] resultValues = linkedListToArray(result);

        assertArrayEquals(expected, resultValues);
    }

    @Test
    public void testSwapPairsRecursive(){
        int[] values = new int[]{1,2,3,4};
        ListNode head = createLinkedList(values);
        int[] expected = new int[]{2,1,4,3};

        ListNode result = solution.swapPairsRecursive(head);
        int[] resultValues = linkedListToArray(result);
        assertArrayEquals(expected, resultValues);
    }

    @Test
    public void testSwapPairsWithEmptyList(){
        ListNode head = null;
        int[] values =  new int[]{};

        assertNull(solution.swapPairsIterative(head));
        assertNull(solution.swapPairsRecursive(head));
    }

    @Test
    public void testSwapPairsIterativeOddElements(){
        int[] values  = new int[]{1,2,3};
        ListNode head = createLinkedList(values);
        int[] expected = new int[]{2,1,3};

        ListNode result = solution.swapPairsIterative(head);
        int[] resultValues = linkedListToArray(result);

        assertArrayEquals(expected, resultValues);
    }

    @Test
    public void testSwapPairsRecursiveOddElements(){
        int[] values  = new int[]{1,2,3};
        ListNode head = createLinkedList(values);
        int[] expected = new int[]{2,1,3};

        ListNode result = solution.swapPairsRecursive(head);
        int[] resultValues = linkedListToArray(result);

        assertArrayEquals(expected, resultValues);
    }
}
