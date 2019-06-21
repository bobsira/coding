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

    static Node insertAtPositionOneBased(Node head, int position, int data){
        Node node = new Node(data);

        if (position == 1) {
            node.next = head;
            head = node;
        }
        else if (position > 1){
            Node current = head;
            for (int i = 0; i < position - 2 ; i++)
                current = current.next;

            if (current.next == null) return head;

            node.next = current.next;
            current.next = node;

        }
        return head;
    }

    private static Node insertAtPositionZeroBased(Node head, int position, int data){
        Node node = new Node(data);

        if (position == 0) {
            node.next = head;
            head = node;
        }
        else if (position > 0){
            Node current = head;
            for (int i = 0; i < position - 1 ; i++)
                current = current.next;

            if (current == null) return head;

            node.next = current.next;
            current.next = node;

        }
        return head;
    }

}
