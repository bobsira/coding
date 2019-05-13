package bytebybyte.linkedlist;

public class NthNode {

     private static int getNthNode(Node head, int index){
        int count = 0;
        while (head != null){
            if (count == index) return head.data;
            count = count + 1;
            head = head.next;
        }
        return -1;
    }

     private static int getNthNodeRecursive(Node head, int index){
        if (head==null)return -1;
        int count = 0;
        if (count == index) return head.data;
        return getNthNodeRecursive(head.next, index - 1);
    }
}
