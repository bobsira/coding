package bytebybyte.linkedlist;

import java.util.Stack;

public class IsPalindrome {

    static boolean isPalindrome(Node head){
        Node slow = head, fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null){ /*FIND MIDDLE ELEMENT*/
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) slow = slow.next; /*ODD NUMBER SKIP MIDDLE ELEMENT*/

        while (slow != null){
            if (stack.pop() != slow.data) return false; /*IF VALUES ARE DIFFERENT IT'S NOT PALINDROME*/
            slow = slow.next;
        }

        return true;
    }
}
