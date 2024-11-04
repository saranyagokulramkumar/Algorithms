import java.util.HashMap;

public class LC138_CopyListWithRandomPointer {

    public Node copyListIteratively(Node head){
        HashMap<Node, Node> copies = new HashMap<>();

        if(head == null)return head;

        Node newNode = new Node(head.val);
        copies.put(head, newNode);

        while(head != null){
            newNode.next = getClone(head.next, copies);
            newNode.random = getClone(head.random, copies);
            head = head.next;
            newNode = newNode.next;
        }
        return copies.get(head);
    }

    private Node getClone(Node node, HashMap<Node, Node> copies){
        if(node != null){
            if(copies.containsKey(node))return copies.get(node);
            Node newNode = new Node(node.val);
            copies.put(node, newNode);
            return newNode;
        }
        return node;
    }

    public Node copyListRecursively(Node head){
        HashMap<Node, Node> copies = new HashMap<>();
        recursiveCopy(head, copies);

        return copies.get(head);
    }

    private void recursiveCopy(Node head, HashMap<Node, Node> copies){
        if(head == null)return;

        Node newNode = new Node(head.val);
        copies.put(head, newNode);
        recursiveCopy(head.next, copies);

        newNode.next = head.next == null ? null : copies.get(head.next);
        newNode.random = head.random == null ? null : copies.get(head.random);
        copies.put(head, newNode);
    }
}
