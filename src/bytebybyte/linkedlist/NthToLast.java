package bytebybyte.linkedlist;

public class NthToLast {


    static Node nthToLast(Node head, int n){ //***
        Node fast = head;
        Node slow = head;

        /*Move fast n nodes into the list*/
        for (int i = 0; i < n; i++) {
            if (fast.next == null) return null;  // out of bounds
            fast = fast.next;
        }

        /*Move them at the same pace. when fast reaches the end. slow will
         * be at the right location*/
        while (fast.next != null){ // next so that 0 is the last element
            fast = fast.next;
            slow = slow.next;
        }

        /*slow pointer will point to the nth node from the end*/
        return slow;
    }

    public static Node getNthFromLast(Node head, int n){
        int list_length = 0;
        Node current = head;

        /*calculate length of linked list*/
        while (current.next != null){
            list_length = list_length + 1;
            current = current.next;
        }

        if (list_length < n) return null;

        /*reset current back to head */
        current = head;

        /*return the (list_length - n + 1) node from the beginning of list*/
        for (int i = 1; i < list_length - n + 1; i++)
            current = current.next;
        return current;
    }

}
