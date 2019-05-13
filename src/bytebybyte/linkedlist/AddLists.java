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

}
