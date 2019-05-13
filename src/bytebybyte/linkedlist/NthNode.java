package bytebybyte.linkedlist;

public class NthNode {

     private static int getNthNode(Node head, int n){
        int count = 0;
        while (head != null){
            if (count == n) return head.data;
            count = count + 1;
            head = head.next;
        }
        return -1;
    }

     private static int getNthNodeRecursive(Node head, int n){
        if (head==null)return -1;
        int count = 0;
        if (count == n) return head.data;
        return getNthNodeRecursive(head.next, n - 1);
    }

    public static Node getKthNode(Node head, int k){
        Node current = head;
        while (k > 0 && head != null){
            current = current.next;
            k--;
        }
        return current;
    }
}
