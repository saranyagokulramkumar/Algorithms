import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LC21_MergeTwoSortedListsTest {
    static LC21_MergeTwoSortedLists solution;

    @BeforeAll
    public static void init(){
        solution = new LC21_MergeTwoSortedLists();
    }

    @Test
    public void testMergeIterative(){
        int[] list1 = new int[]{1,2,4};
        int[] list2 = new int[]{1,3,4};
        int[] expectedResult = new int[]{1,1,2,3,4,4};

        ListNode l1 = LinkedListUtils.createLinkedList(list1);
        ListNode l2 = LinkedListUtils.createLinkedList(list2);

        ListNode result = solution.mergeTwoListsIterative(l1, l2);
        int[] resultList = LinkedListUtils.linkedListToArray(result);

        assertArrayEquals(expectedResult, resultList);
    }

    @Test
    public void testMergeRecursive(){
        int[] list1 = new int[]{1,2,4};
        int[] list2 = new int[]{1,3,4};
        int[] expectedResult = new int[]{1,1,2,3,4,4};

        ListNode l1 = LinkedListUtils.createLinkedList(list1);
        ListNode l2 = LinkedListUtils.createLinkedList(list2);

        ListNode result = solution.mergeTwoListsRecursive(l1, l2);
        int[] resultList = LinkedListUtils.linkedListToArray(result);

        assertArrayEquals(expectedResult, resultList);
    }

}
