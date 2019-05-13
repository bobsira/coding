package bytebybyte.linkedlist;

public class Search {

     private static boolean search(Node head, int data){
        while (head != null){
            if (head.data == data) return true;
            head = head.next;
        }
        return false;
    }

     private static boolean searchRecursive(Node head, int data){
        if (head == null) return false;
        if (head.data == data) return true;
        return searchRecursive(head.next,data);
    }
}
