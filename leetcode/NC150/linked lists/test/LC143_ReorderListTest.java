import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LC143_ReorderListTest {

    static LC143_ReorderList solution;

    @BeforeAll
    public static void init(){
        solution = new LC143_ReorderList();
    }

    @Test
    public void testReorderListEvenLength(){
        int[] list = new int[]{1,2,3,4,5,6};
        int[] expectedResult = new int[]{1,6,2,5,3,4};

        ListNode l1 = LinkedListUtils.createLinkedList(list);
        solution.reorderList(l1);
        int[] result = LinkedListUtils.linkedListToArray(l1);

        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testReorderListOddLength(){
        int[] list = new int[]{1,2,3,4,5,};
        int[] expectedResult = new int[]{1,5,2,4,3};

        ListNode l1 = LinkedListUtils.createLinkedList(list);
        solution.reorderList(l1);
        int[] result = LinkedListUtils.linkedListToArray(l1);

        assertArrayEquals(expectedResult, result);
    }
}
