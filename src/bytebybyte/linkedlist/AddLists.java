package bytebybyte.linkedlist;

public class AddLists {
    private static Node addList(Node firstList, Node secondList, int carry){
        if (firstList == null && secondList == null && carry ==0 ) return null;
        LinkedList result = new LinkedList();
        int sum = carry;
        if (firstList != null) sum = sum + firstList.data;
        if (secondList != null) sum = sum + secondList.data;
        int value = sum % 10;
        result.head = new Node(value);
        if (firstList != null || secondList != null)
            result.head.next = addList(firstList == null ? null : firstList.next, secondList == null ? null : secondList.next, sum >= 10 ? 1 : 0);
        return result.head;
    }

    private static Node addList(Node firstList, Node secondList){
        return addList(firstList,secondList,0);
    }

    public static void main(String[] args) {
        LinkedList first = new LinkedList();
        LinkedList second = new LinkedList();
        Node one = new Node(7);
        Node two = new Node(1);
        Node three = new Node(6);
        Node four = new Node(5);
        Node five = new Node(9);
        Node six = new Node(2);

        first.head = one; one.next = two; two.next = three;
        second.head = four; four.next = five; five.next = six;

        Node result = addList(first.head,second.head,0);
        while (result != null){
            System.out.print( result.data + " ");
            result = result.next;
        }

    }
}
