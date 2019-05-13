package bytebybyte.linkedlist;

public class GetCount {

    private static int getCountRecursive(Node head){
        if (head == null) return 0;
        return getCountRecursive(head.next) + 1;
    }

    private static int getCount(Node head){
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    private static int getNodeDataCount(Node head, int data){
        int count = 0;
        while (head.next != null){
            if (head.data == data){
                count = count + 1;
                head = head.next;
            }
        }
        return count;
    }

}
