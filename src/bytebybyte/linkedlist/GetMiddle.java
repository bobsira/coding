package bytebybyte.linkedlist;

public class GetMiddle {

    private static Node getMiddle(Node head){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /*Method 1: Traverse the whole linked list and count the no. of nodes.
     * Now traverse the list again till count/2 and return the node at count/2.
     *
     * Method 2: Traverse linked list using two pointers. Move one pointer by one and other pointer by two.
     * When the fast pointer reaches end slow pointer will reach middle of the linked list.
     * */

}
