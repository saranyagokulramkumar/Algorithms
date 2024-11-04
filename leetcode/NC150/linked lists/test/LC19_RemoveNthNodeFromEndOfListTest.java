import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LC19_RemoveNthNodeFromEndOfListTest {
    static LC19_RemoveNthNodeFromEndOfList solution;

    @BeforeAll
    public static void init(){
        solution = new LC19_RemoveNthNodeFromEndOfList();
    }

    @Test
    public void testTwoPassRemove(){
        int[] list = new int[]{1,2,3,4,5};
        int n = 2;
        int[] expectedResult = new int[]{1,2,3,5};

        ListNode l1 = LinkedListUtils.createLinkedList(list);
        ListNode result = solution.twoPassRemove(l1, n);
        int[] resultList = LinkedListUtils.linkedListToArray(result);

        assertArrayEquals(expectedResult, resultList);

        list = new int[]{1,2};
        n = 1;
        expectedResult = new int[]{1};

        l1 = LinkedListUtils.createLinkedList(list);
        result = solution.twoPassRemove(l1, n);
        resultList = LinkedListUtils.linkedListToArray(result);

        assertArrayEquals(expectedResult, resultList);
    }

    @Test
    public void testOnePassRemove(){
        int[] list = new int[]{1,2,3,4,5};
        int n = 2;
        int[] expectedResult = new int[]{1,2,3,5};

        ListNode l1 = LinkedListUtils.createLinkedList(list);
        ListNode result = solution.onePassRemove(l1, n);
        int[] resultList = LinkedListUtils.linkedListToArray(result);

        assertArrayEquals(expectedResult, resultList);

        list = new int[]{1,2};
        n = 1;
        expectedResult = new int[]{1};

        l1 = LinkedListUtils.createLinkedList(list);
        result = solution.onePassRemove(l1, n);
        resultList = LinkedListUtils.linkedListToArray(result);

        assertArrayEquals(expectedResult, resultList);
    }
}
