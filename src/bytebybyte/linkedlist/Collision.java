package bytebybyte.linkedlist;

import java.util.HashSet;

public class Collision {

    private static boolean detectLoop(Node head){
            /**
             * Use Hashing: Traverse the list one by one and keep putting the node addresses in a Hash Table.
             * At any point, if NULL is reached then return false and if next of current node points to any of the
             * previously stored nodes in Hash then return true.
            **/
        HashSet<Node> nodeHashSet= new HashSet<Node>();
        while (head != null){
            /**
             * If we have already have this node in hash map it means their is a cycle
             * (Because you we encountering the node second time).
             **/
            if (nodeHashSet.contains(head)) return true;
            nodeHashSet.add(head);
            /** If we are seeing the node for the first time, insert it in hash**/
            head = head.next;
        }
        return false;
    }

    private static boolean detectLoopFloydCycleFindingAlgorithm(Node head){
        /** Floyd’s Cycle-Finding Algorithm:
         * Traverse linked list using two pointers.
         * Move one pointer by one and other pointer by two.
         * If these pointers meet at same node then there is a loop.
         * If pointers do not meet then linked list does not have loop.
         **/
        Node fast = head, slow = head;
        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    private static Node findBeginning(Node head){
        Node fast = head, slow = head;

        /**
         * Find meeting point. This will be LOOP_SIZE - K steps into the linked list.
         **/
        while (fast != null && fast.next != null){
            slow =slow.next;
            fast = fast.next.next;
            if (slow == fast) break; // Collision
        }

        /**
         * Error check - no meeting point, and therefore no loop
         **/
        if (fast == null || fast.next == null) return null;

        /**
         * Move slow to Head. Keep fast at Meeting Point. Each are k steps from the
         * Loop Start. If they move at the same pace, they must meet at Loop Start.
         * */
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        /**
         * Both now point to the start of the loop
         * **/
        return fast;
    }
    /**
    * 1. Create two pointers, FastPointer and SlowPointer.
    * 2. MoveFastPointer at a rate of 2 steps and SlowPointer at a rate of 1 step.
    * 3. When they collide, move SlowPointer to Linked List Head. Keep FastPointer where it is.
    * 4. Move SlowPointer and FastPointer at a rate of one step. Return the new collision point.
     * */



}
