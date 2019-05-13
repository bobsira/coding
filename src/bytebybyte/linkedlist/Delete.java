package bytebybyte.linkedlist;

public class Delete {

    static void deleteFirstOccurentNode(Node head, int data){
        Node current = head, previous = null;

        if (current != null && current.data == data){
            head = current.next;
            return;
        }

        while (current != null && current.data != data){
            previous = current;
            current = current.next;
        }

        if (current == null) return;

        previous.next = current.next;
    }

    static void deleteNodeAtPosition(Node head, int position){
        if (head == null) return;
        Node current = head;
        if (position == 0){
            head = current.next;
            return;
        }

        for (int i = 0; i < position - 1 && current.next != null; i++)
            current = current.next;

        if (current.next == null) return;

        current.next = current.next.next;
    }

    static Node deleteList(Node head){
        head = null;
        return head;
    }

    static boolean deleteNode(Node node){
        if (node == null || node.next == null) return false; // Failure
        Node next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }
    /*
    * Implement an algorithm to delete a node in the middle
    * (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list,
    * given only access to that node.
    *
    * In this problem, you are not given access to the head of the linked list.
    * You only have access to that node.
    * The solution is simply to copy the data from the next node over to the current node,
    * and then to delete the next node*/
}
