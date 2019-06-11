package bytebybyte.linkedlist;

public class Intersection {

    private static Node findIntersection(Node first, Node second){
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

    private static class TailAndSize{
        Node tail;
        int size;
        TailAndSize(Node tail, int size){
            this.tail = tail;
            this.size = size;
        }
    }

    private static TailAndSize getTailAndSize(Node head){
        if (head == null) return null;
        int size = 1;
        while (head.next != null){
            head = head.next;
            size = size + 1;
        }
        return new TailAndSize(head, size);
    }

    /**
     *
     * 1. Run through each linked list to get the lengths and the tails.
     * 2. Compare the tails. If they are different (by reference, not by value), return immediately.There is no inter- section.
     * 3. Set two pointers to the start of each linked list.
     * 4. On the longer linked list, advance its pointer by the difference in lengths.
     * 5. Now, traverse on each linked list until the pointers are the same.
     * **/

}
