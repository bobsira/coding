package bytebybyte.linkedlist;

public class PrintLinkedList {

    public static void printLinkedList(Node head){
        if (head == null) System.out.println("Linked List is Empty");
        while (head != null){
            System.out.print(head.data + "-> ");
            head = head.next;
        }
    }


    private static void printReverseList(Node head){
        if (head == null) return;
        printReverseList(head.next);
        System.out.print(head.data + "-> ");
    }
    /*  1 -> 2 -> 3 -> null
     * printReverseList(1 -> 2 -> 3 -> null)
     * printReverseList(2 -> 3  -> null)
     * printReverseList(3 -> null)
     * printReverseList(null) * */

}
