package algoritms;

public class ListNode {
    public Node head;
    public class Node {
        public int value;
        public Node next;
    }

    public Node reverseListNode() {
        Node current = head;
        Node prev = null;

        while(current != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
