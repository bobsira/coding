package bytebybyte.linkedlist;

public class Reverse {

    private static Node reverse(Node head){
        Node previous = null , current = head , next = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
        return head;
    }

    /**
     * 1. Initialize three pointers PREVIOUS as null, CURRENT as head and NEXT as null
     * 2. Iterate through the linked list doing the following
     *      (a). Before changing the next of current store the next node
     *      next = current->next
     *      (b). Then change the next of current. This is the actual reversing happens(next of current to previous)
     *      current->next = previous
     *      (c). Move previous and current one step forward
     *      previous = current
     *      current = next
     * **/

}
