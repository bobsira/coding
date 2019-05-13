package bytebybyte.linkedlist;

public class Partition {

    public static Node partition(Node list_head, int key){
        Node tail = list_head, head = list_head;
        while (list_head != null){
            Node next = list_head.next;
            if (list_head.data < key){
                /*insert at the head*/
                list_head.next = head;
                head = list_head;
            }else {
                /*insert at the tail*/
                tail.next = list_head;
                tail = list_head;
            }
            list_head = next;
        }
        tail.next = null;
        /*the head has changed so return it*/
        return list_head;
    }
}
