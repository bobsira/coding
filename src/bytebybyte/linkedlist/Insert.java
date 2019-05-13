package bytebybyte.linkedlist;

public class Insert {

    static Node insertAtFront(Node head, int data){
        Node node = new Node(data);
        node.next = head;
        return node;
    }

    static void insertAfterNode(Node previous, int data){
        if (previous == null) return; //System.out.println("The given previous node cannot be null");
        Node node = new Node(data);
        node.next = previous.next;
        previous.next = node;
    }

    static void insertAtEnd(Node head, int data){
        Node node = new Node(data);
        node.next = null;
        if (head == null){
            head = node;
            return;
        }
        while (head.next != null)
            head = head.next;
        head.next = node;
    }


}
