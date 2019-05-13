package bytebybyte.linkedlist;

import java.util.HashSet;

public class DeleteDups {

    static void removeDups(Node head){
        HashSet<Integer> hashSet = new HashSet<>();
        Node previous = null;
        while (head != null){
            if (hashSet.contains(head.data)){
                previous.next = head.next;
            }else {
                hashSet.add(head.data);
                previous = head;
            }
            head = head.next;
        }

        /*
         * In order to remove duplicates from a linked list, we need to be able to track duplicates
         * A simple hash table will work well here
         * we simply iterate through the linked list, adding each element to a hash table.
         * When we discover a duplicate element, we remove the element and continue iterating.
         * We can do this all in one pass since we are using a linked list
         */
    }

    static void removeDupsTwo(Node head){
        Node current = head;
        while (current != null){
            //Remove all future nodes that have the same value
            Node runner = current;
            while (runner.next != null){
                if (runner.next.data == current.data)
                    runner.next = runner.next.next;
                else
                    runner = runner.next;
            }
            current = current.next;
        }
    }

    public static void removeDuplicates(Node head){
        /*
         * Traverse the list from the head (or start) node.
         * While traversing, compare each node with its next node.
         * If data of next node is same as current node then delete the next node.
         * Before we delete a node, we need to store next pointer of the node
         * */
        Node current = head;
        /* Pointer to store the next pointer of a node to be deleted*/
        Node next_next;
        if (head == null) return;
        while (current.next != null){
            /*Compare current node with the next node */
            if (current.data == current.next.data){
                next_next = current.next.next;
                current.next = null;
                current.next = next_next;
            }
            else current = current.next; /*advance */
        }
    }

}
