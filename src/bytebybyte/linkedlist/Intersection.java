package bytebybyte.linkedlist;

public class Intersection {

    static Node findIntersection(Node first, Node second){
        if (first == null || second == null) return null;

        /* GET TAIL AND SIZES */
        TailAndSize first_tail_size = getTailAndSize(first);
        TailAndSize second_tail_size = getTailAndSize(second);

        /* If different tail nodes, then there's no intersection */
        if (first_tail_size.tail != second_tail_size.tail) return null;

        /* set pointers to the start of each linked list */
        Node shorter = first_tail_size.size < second_tail_size.size ? first : second;
        Node longer = first_tail_size.size < second_tail_size.size ? second : first;

        /* Advance the pointer for the longer linked list by difference in lengths. */
        longer = NthNode.getKthNode(longer, Math.abs(first_tail_size.size - second_tail_size.size));

        /* move both pointer until you have a collision */
        while (shorter != longer){
            shorter = shorter.next;
            longer = longer.next;
        }

        /* return either one */
        return longer;
    }

    static class TailAndSize{
        Node tail;
        int size;
        TailAndSize(Node tail, int size){
            this.tail = tail;
            this.size = size;
        }
    }

    static TailAndSize getTailAndSize(Node list_head){
        if (list_head == null) return null;
        int size = 1;
        while (list_head.next != null){
            list_head = list_head.next;
            size = size + 1;
        }
        return new TailAndSize(list_head, size);
    }

}
