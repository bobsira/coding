package test_questions_one;

import bytebybyte.linkedlist.LinkedList;
import bytebybyte.linkedlist.Node;
import bytebybyte.linkedlist.PrintLinkedList;



public class CrushLinkedList {

    private static Node crushLinkedListOne(Node head){
        Node current = head;

        if (current == null) return null;

        Node nextNode = null;
        while (current.next != null){
            if (current.data == current.next.data){
                nextNode = current.next.next;
                current.next = null;
                current.next = nextNode;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    private static Node crushLinkedListTwo(Node head){
        Node current = head;

        if (current == null) return null;

        Node previous = head;
        Node next = null;

        while (current.next != null){
            if (current.data == current.next.data){

                next = current.next.next;
                current.next = null;
                current.next = next;

                previous = next;
                current = previous;

            } else {
                current = current.next;
            }
        }
        return head;
    }

    private static Node crushLinkedList(Node head){
        Node current = head;
        while (current != null){
            Node temp = current;
            while (temp != null && temp.data == current.data) {
                System.out.println("Here + " + temp.data + " ->" + current.data);
                temp = temp.next;
            }
            current.next = temp;
            current = current.next;
        }
        return head;
    }



    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(1);
        linkedList.head.next = new Node(2);
        linkedList.head.next.next = new Node(3);
        linkedList.head.next.next.next = new Node(3);
        linkedList.head.next.next.next.next = new Node(4);
        linkedList.head.next.next.next.next.next = new Node(4);
        linkedList.head.next.next.next.next.next.next = new Node(5);
        linkedList.head.next.next.next.next.next.next.next = new Node(6);
        linkedList.head.next.next.next.next.next.next.next.next = new Node(6);
        linkedList.head.next.next.next.next.next.next.next.next.next = new Node(7);

        PrintLinkedList.printLinkedList(linkedList.head);

        System.out.println();
    }
}
