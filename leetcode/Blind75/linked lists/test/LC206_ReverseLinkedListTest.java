import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LC206_ReverseLinkedListTest {
    static LC206_ReverseLinkedList solution;

    @BeforeAll
    public static void init(){
        solution = new LC206_ReverseLinkedList();
    }

    @Test
    public void testReverseListIterative(){
        int[] values = new int[]{1,2,3,4,5};
        ListNode head = LinkedListUtils.createLinkedList(values);
        int[] expected = new int[]{5,4,3,2,1};

        ListNode reversedHead = solution.reverseListIterative(head);
        int[] reversedList = LinkedListUtils.linkedListToArray(reversedHead);

        assertArrayEquals(expected, reversedList);
    }

    @Test
    public void testReverseListIterativeWithSingleElement(){
        int[] values = new int[]{1};
        ListNode head = LinkedListUtils.createLinkedList(values);
        int[] expected = new int[]{1};

        ListNode reversedHead = solution.reverseListIterative(head);
        int[] reversedList = LinkedListUtils.linkedListToArray(reversedHead);

        assertArrayEquals(expected, reversedList);
    }

    @Test
    public void testReverseListIterativeWithNoElements(){
        ListNode head = null;

        assertNull(solution.reverseListIterative(head));
    }

    @Test
    public void testReverseListIterativeWithDuplicateValues(){
        int[] values = new int[]{3,3,1,1,2};
        ListNode head = LinkedListUtils.createLinkedList(values);
        int[] expected = new int[]{2,1,1,3,3};

        ListNode reversedHead = solution.reverseListIterative(head);
        int[] reversedList = LinkedListUtils.linkedListToArray(reversedHead);

        assertArrayEquals(expected, reversedList);
    }

    @Test
    public void testReverseListRecursive(){
        int[] values = new int[]{1,2,3,4,5};
        ListNode head = LinkedListUtils.createLinkedList(values);
        int[] expected = new int[]{5,4,3,2,1};

        ListNode reversedHead = solution.reverseListRecursive(head);
        int[] reversedList = LinkedListUtils.linkedListToArray(reversedHead);

        assertArrayEquals(expected, reversedList);
    }
}
