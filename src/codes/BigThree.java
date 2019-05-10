package codes;

import java.util.*;

public class BigThree {

    static void printBig3(int arr[], int arr_size){
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        if (arr_size < 3){
            System.out.println("Invalid Input");
            return;
        }
        for (int i = 0; i < arr_size; i++) {
            if (arr[i] > first){
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second){
                third = second;
                second = arr[i];
            } else if (arr[i] > third)
                third = arr[i];
        }
        System.out.println(first + " " + second + " " +third);
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;


        printBig3(arr,n);

    }

    public static class TreeUtility {

        static private class Node {
            int data;
            Node left, right, parent;
            Node(int data){
                this.data = data;
                left = right = null;
                parent = null; //this is for the special inorder successor
            }
        }

        static private class BinaryTree {
            Node root;

            BinaryTree(){}
            BinaryTree(Node root){
                this.root = root;
            }

             Node insert(Node root, int data){
                 if (root == null) return new Node(data);
                 else {
                     Node temp = null;

                     if (data <= root.data) {
                         temp = insert(root.left,data);
                         root.left = temp;
                         temp.parent = root;
                     }
                     else {
                         temp = insert(root.right, data);
                         root.right = temp;
                         temp.parent = root;
                     }
                 }
                 return root;
             }

            int minValue(Node root){
                Node current = root;
                while (current.left != null){
                    current = current.left;
                }
                return current.data;
            }
            int minValueRecursively(Node root){
                if (root == null) return -1;
                if (root.left == null) return root.data;
                return minValueRecursively(root.left);
            }
            Node MinValue(Node root){
                while (root.left != null) root = root.left;
                return root;
            }

            int maxValue(Node root){
                Node current = root;
                while (current.right != null){
                    current = current.right;
                }
                return current.data;
            }

            Node minNode(Node root){
                Node temp = root;
                while (temp.left != null){
                    temp = temp.left;
                }
                return temp;
            }
            Node maxNode(Node root){
                Node temp = root;
                while (temp.right != null) temp = temp.right;
                return temp;
            }

            boolean search(Node root, int data){
                if (root == null) return false;
                else if (data == root.data) return true;
                else if (data <= root.data) return search(root.left, data);
                else return search(root.right,data);
            }
            Node Search(Node root, int data){
                if (root == null) return null;
                else if (data == root.data) return root;
                else if (data <= root.data) return Search(root.left,data);
                else return Search(root.right,data);
            }

            static int height(Node root){
                if (root == null) return -1;
                int left = height(root.left);
                int right = height(root.right);
                return Math.max(left,right) + 1;
            }

            void levelOder(Node root){
                Queue<Node> queue = new LinkedList<Node>();
                queue.add(root);
                while (!queue.isEmpty()){
                    Node temp = queue.peek();
                    System.out.print(temp.data+ " ");
                    if (temp.left != null) queue.add(temp.left);
                    if (temp.right != null) queue.add(temp.right);
                    queue.remove();
                }
            }

            void inOrder(Node root){
                if(root == null) return;
                inOrder(root.left);
                System.out.print(root.data + " ");
                inOrder(root.right);
            }
            void preOrder(Node root){
                if(root == null) return;
                System.out.print(root.data + " ");
                preOrder(root.left);
                preOrder(root.right);
            }
            void postOrder(Node root){
                if(root == null) return;
                postOrder(root.left);
                postOrder(root.right);
                System.out.print(root.data + " ");
            }

            boolean isBST(Node root){
                if (root == null) return true;
                if (isSubtreeLesser(root.left, root.data) && isSubtreeGreater(root.right, root.data) && isBST(root.left) && isBST(root.left)) return true;
                else return false;
            }
            boolean isSubtreeLesser(Node root, int value){
                if (root == null) return true;
                if (root.data < value && isSubtreeLesser(root.left, value) && isSubtreeLesser(root.right, value)) return true;
                else return false;
            }
            boolean isSubtreeGreater(Node root, int value){
                if (root == null) return true;
                if (root.data > value && isSubtreeGreater(root.left, value) && isSubtreeGreater(root.right, value)) return true;
                return false;
            }

            boolean isBinarySearchTree(Node root){
                return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
            boolean isBSTUtil(Node root, int min, int max){
                if (root == null) return true;
                if (root.data > min && root.data < max
                        && isBSTUtil(root.left,min,root.data)
                        && isBSTUtil(root.right, root.data, max))
                    return true;
                else return false;
            }

            Node delete(Node root, int data){
                if (root == null) return root;
                else if (data < root.data) root.left = delete(root.left,data);
                else if (data > root.data) root.right = delete(root.right,data);
                else {
                    //case 1: no child
                    if (root.left == null && root.right == null) root = null;
                    //case 2: one child
                    else if (root.left == null){
                        return root.right;
                    }
                    else if (root.right == null){
                        return root.left;
                    }
                    //case 3: two children
                    else {
                        root.data = minValue(root.right);
                        root.right = delete(root.right, root.data);
                    }
                }
                return root;
            }
            Node deleteOPT(Node root, int data){
                if (root == null) return root;
                else if (data < root.data) {
                    root.left = delete(root.left, data);
                    return root;
                }
                else if (data > root.data) {
                    root.right = delete(root.right, data);
                    return root;
                }
                else {
                    //we reach here when root is the node to be deleted
                    if (root.left == null) return root.right;
                    else if (root.right == null) return root.left;
                    else {
                        Node parentOfSuccessor = root.right;
                        Node successor = minNode(root.right);
                        //delete successor since it is always left of its parent
                        //we can safely make successor's right right child as left of its parent.
                        parentOfSuccessor.left = successor.right;
                        //copy successor data to root
                        root.data = successor.data;
                        return root;
                    }
                }
            }

            Node inOrderSuccessor(Node node){
                if (node == null) return null;
                if (node.right != null) return minNode(node.right);
                else {
                    Node parent = node.parent;
                    while (parent != null && node == parent.right){
                        node = parent;
                        parent = parent.parent;
                    }
                    return parent;
                }
            }
            Node getInOrderSuccessor(Node root, int data){
                Node current = Search(root, data);
                if (current == null) return null;
                if (current.right != null) return MinValue(current.right);
                else {
                    Node successor = null;
                    Node ancestor = root;
                    while (ancestor != current){
                        if (current.data < ancestor.data){
                            successor = ancestor;
                            ancestor = ancestor.left;
                        } else ancestor = ancestor.right;
                    }
                    return successor;
                }
            }

            public static Node createMinimalBST(int[] array){
                return createMinimalBST(array,0,array.length - 1);
            }
            private static Node createMinimalBST(int array[], int start, int end){
                if (end < start) return null;
                int mid = (start + end) / 2;
                Node node = new Node(array[mid]);
                node.left = createMinimalBST(array,start,mid-1);
                node.right = createMinimalBST(array,mid+1,end);
                return node;
            }

            public static ArrayList<LinkedList<Node>> createLevelLinkedList(Node root){
                ArrayList<LinkedList<Node>> results = new ArrayList<LinkedList<Node>>();
                LinkedList<Node> current = new LinkedList<Node>();
                if (root != null) current.add(root); //visit root node
                while (current.size() > 0){
                    results.add(current); //add previous level
                    LinkedList<Node> parents = current; //go to the next level
                    current = new LinkedList<Node>();
                    //visit the children
                    for (Node parent: parents){
                        if (parent.left != null) current.add(parent.left);
                        if (parent.right != null) current.add(parent.right);
                    }
                }
                return results;
            }
            public static void printResult(ArrayList<LinkedList<Node>> result){
                int depth = 0;
                for(LinkedList<Node> entry : result) {
                    Iterator<Node> i = entry.listIterator();
                    System.out.print("Link list at depth " + depth + ":");
                    while(i.hasNext()){
                        System.out.print(" " + ((Node)i.next()).data);
                    }
                    System.out.println();
                    depth++;
                }
            }

            public static boolean isBalanced(Node root){
                if (root == null) return  true; //base case
                int heightDiff = height(root.left) - height(root.right);
                if (Math.abs(heightDiff) > 1) return false;
                else return isBalanced(root.left) && isBalanced(root.right); //recurse
            }
            public static int checkHeight(Node root){
                if (root == null) return -1;
                int leftHeight = checkHeight(root.left);
                if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //pass error up
                int rightHeight = checkHeight(root.right);
                if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // pass error up
                int heightDiff = leftHeight - rightHeight;
                if (Math.abs(heightDiff) > 1) return Integer.MIN_VALUE; //found error, pass it back
                else return Math.max(leftHeight,rightHeight) + 1;
            }
            public boolean isBalancedEfficient(Node root) {
                return checkHeight(root) != Integer.MIN_VALUE;
            }
        }

        public static void main(String[] args) {

    //        Node root = new Node(20);
    //        BinaryTree binaryTree = new BinaryTree(root);
    //        binaryTree.insert(root, 8);
    //        binaryTree.insert(root, 22);
    //        binaryTree.insert(root, 4);
    //        binaryTree.insert(root, 12);
    //        binaryTree.insert(root, 10);
    //        binaryTree.insert(root, 14);

    //        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    //        BinaryTree binaryTree = new BinaryTree();
    //        Node root = BinaryTree.createMinimalBST(array);
    //        ArrayList<LinkedList<Node>> lists = BinaryTree.createLevelLinkedList(root);
    //        BinaryTree.printResult(lists);

        }
    }

    public static class Recursion {
        static int F[] = new int[51];

        static int Fact(int n){
            if (n == 0) return 1;
            else return n * Fact(n - 1);
        }

        static int Fib1(int n){
            if (n <= 1) return n;
            else return Fib1(n - 1) + Fib1(n-2);
        }

        static int Fib2(int n){
            if (n <=1 ) return n;
            int F = 0, F1 = 0, F2 = 1;
            for (int i = 2; i < n; i++){
                F = F1 + F2;
                F1 = F2;
                F2 = F;
            }
            return F;
        }
        static int Fib3(int n){
            if (n <=1 ) return n;
            if (F[n] != -1) return F[n];
            F[n] = Fib3(n-1) + Fib3(n-2);
            return F[n];
        }

        static int ModExpo(int x, int n, int m){
            if (n==0) return 1;
            else if (n % 2 ==0){
                int y = ModExpo(x,n /2, m);
                return (y * y) % m;
            }
            else
                return ((x % m) * ModExpo(x,n-1,m)) % m;
        }

        public static void main(String[] args) {
            for (int i = 0; i < 51; i++) {
                F[i] = -1;
            }

            System.out.println(Fib3(40));
            System.out.println(ModExpo(5,2,7));
        }
    }

    public static class LinkedListUtility {

        private static class Node{
            Node next;
            int data;
            Node(int data) { this.data = data; }
        }

        private static class LinkedList {
            Node head;
        }

        public static void printList(Node head){
            if (head == null) System.out.println("Empty");
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
        }

        public static Node insertAtFront(Node head, int data){
            Node node = new Node(data);
            node.next = head;
            return node;
        }

        public static void insertAfterNode(Node previous, int data){
            if (previous == null){
                System.out.println("The given previous node cannot be null");
                return;
            }
            Node node = new Node(data);
            node.next = previous.next;
            previous.next = node;
        }

        public static void insertAtEnd(Node head, int data){
            Node node = new Node(data);
            node.next = null;
            if (head == null){
                head = node;
                return;
            }
            while (head.next != null) head = head.next;
            head.next = node;
        }

        public static void deleteFirstOccurentNode(Node head, int data){
            Node current = head, previous = null;
            if (current != null && current.data == data){
                head = current.next;
                return;
            }
            while (current != null && current.data != data){
                previous = current;
                current = current.next;
            }
            if (current == null) return;
            previous.next = current.next;
        }

        public static void  deleteNodeAtPosition(Node head, int postion){
            if (head == null) return;
            Node current = head;
            if (postion == 0){
                head = current.next;
                return;
            }
            for (int i = 0; current.next != null && i < postion - 1; i++)
                current = current.next;

            if (current.next == null)
                return;
            current.next = current.next.next;
        }

        /*delete the middle given node except the first or last*/
        public static boolean deleteNode(Node node){
            /*copy data from the next node over to the current node then delete the next node*/
            if (node == null || node.next == null) return false;
            Node next = node.next;
            node.data = next.data;
            node.next = next.next;
            return true;
        }

        public static Node deleteList(Node head){
            head = null;
            return head;
        }

        public static int getCount(Node head){
            int count = 0;
            while (head != null){
                count++;
                head = head.next;
            }
            return count;
        }

        public static int getCountRecursive(Node head){
            if (head == null) return 0;
            return getCountRecursive(head.next) + 1;
        }

        public static boolean search(Node head, int data){
            while (head != null){
                if (head.data == data) return true;
                head = head.next;
            }
            return false;
        }

        public static boolean searchRecursive(Node head, int data){
            if (head == null) return false;
            if (head.data == data) return true;
            return searchRecursive(head.next,data);
        }

        public static int getNthNode(Node head, int index){
            int count = 0;
            while (head != null){
                if (count == index) return head.data;
                count = count + 1;
                head = head.next;
            }
            return -1;
        }

        public static int getNthNodeRecursive(Node head, int index){
            if (head==null)return -1;
            int count = 0;
            if (count == index) return head.data;
            return getNthNodeRecursive(head.next, index - 1);
        }

        public static Node getNthFromLast(Node head, int n){
            int length = 0;
            Node current = head;
            /*calculate length of linked list*/
            while (current != null){
                length = length + 1;
                current = current.next;
            }

            if (length < n) return null;
            current = head;
            /*return the (length - n + 1) node from the beginning of list*/
            for (int i = 1; i < length - n + 1; i++)
                current = current.next;
            return current;
        }

        public static Node getNthFromLast2(Node head, int n){
            /*maintain two pointers first and slow*/
            Node slow = head, fast = head;
            int count = 0;
            if (head != null){
                /*move fast pointer to n nodes from head*/
                while (count < n){
                    if (fast == null) return null;
                    fast = fast.next;
                    count++;
                }
                /*move both fast and slow pointers one by one util fast pointer reaches end*/
                while (fast != null){
                    slow = slow.next;
                    fast = fast.next;
                }
                /*slow pointer will point to the nth node from the end*/
                return slow;
            }
            return null;
        }
        //THIRD VERSION OF ABOVE
        public static Node nthToLast(Node head, int n){
            Node fast = head, slow = head;
            /*move fast n nodes into the list*/
            for (int i = 0; i < n; i++){
                if (fast == null) return null; //out of bounds
                fast = fast.next;
            }
            /*move them at the same pace. when fast reaches the end. slow will
            * be at the right location*/
            while (fast != null){
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }

        public static Node getMiddle(Node head){
            /*Method 1: Traverse the whole linked list and count the no. of nodes.
            * Now traverse the list again till count/2 and return the node at count/2.
            *
            * Method 2: Traverse linked list using two pointers. Move one pointer by one and other pointer by two.
            * When the fast pointer reaches end slow pointer will reach middle of the linked list.
            * */
            Node fast = head;
            Node slow = head;
            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public static int countOccurrencesOfData(Node head, int data){
            int count = 0;
            while (head.next != null){
                if (head.data == data){
                    count = count + 1;
                    head = head.next;
                }
            }
            return count;
        }

        public static boolean detectLoop(Node head){
            /*Use Hashing: Traverse the list one by one and keep putting the node addresses in a Hash Table.
            At any point, if NULL is reached then return false and if next of current node points to any of the
            previously stored nodes in Hash then return true.
            * */
            HashSet<Node> nodeHashSet= new HashSet<Node>();
            while (head != null){
                /*If we have already have this node in hash map it means their is a cycle (Because you we encountering the node second time).*/
                if (nodeHashSet.contains(head)) return true;
                nodeHashSet.add(head);
                /* If we are seeing the node for the first time, insert it in hash */
                head = head.next;
            }
            return false;
        }

        public static boolean detectLoopFloydCycleFindingAlgorithm(Node head){
            // Floyd’s Cycle-Finding Algorithm:
            // Traverse linked list using two pointers.
            // Move one pointer by one and other pointer by two.
            // If these pointers meet at same node then there is a loop.
            // If pointers do not meet then linked list does not have loop.
            Node fast = head, slow = head;
            while (slow != null && fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }

        public static int countNodesInLinkedListNode(Node head){
            /*We know that Floyd’s Cycle detection algorithm terminates when fast and slow pointers meet at a common point.
            We also know that this common point is one of the loop nodes (2 or 3 or 4 or 5 in the above diagram).
            We store the address of this common point in a pointer variable say ptr.
            Then we initialize a counter with 1 and start from the common point and keeps on visiting next node
            and increasing the counter till we again reach the common point(ptr).
            At that point, the value of the counter will be equal to the length of the loop.
            * */
            Node fast = head, slow = head;
            while (slow != null && fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast){
                    return countNodes(slow);
                }
            }
            return  0;
        }

        public static void removeDuplicates(Node head){
            /*
            * Traverse the list from the head (or start) node.
            * While traversing, compare each node with its next node.
            * If data of next node is same as current node then delete the next node.
            * Before we delete a node, we need to store next pointer of the node
            * */
            Node current = head;
            /* Pointer to store the next pointer of a node to be deleted*/
            Node next_next;
            if (head == null) return;
            while (current.next != null){
                /*Compare current node with the next node */
                if (current.data == current.next.data){
                    next_next = current.next.next;
                    current.next = null;
                    current.next = next_next;
                }
                else current = current.next; /*advance */
            }
        }

        public static int countNodes(Node start){
            int count = 1;
            Node current = start;
            while (current.next != start){
                count = count + 1;
                current = current.next;
            }
            return count;
        }

        public static void removeDuplicatesSorted(Node head){
            /*
            * We traverse the link list from head to end.
            * For every newly encountered element,
            * we check whether it is in the hash table: if yes, we remove it;
            * otherwise we put it in the hash table.
            * */
            HashSet<Integer> hashSet = new HashSet<>();
            Node previous = null;
            while (head != null){
                /* if current value is seen before */
                if (hashSet.contains(head.data)) previous.next = head.next;
                else {
                    hashSet.add(head.data);
                    previous = head;
                }
                head = head.next;
            }
        }

        public static Node partition(Node list_head, int key){
            Node tail = list_head, head = list_head;
            while (list_head != null){
                Node next = list_head.next;
                if (list_head.data < key){
                    /*insert at the head*/
                    list_head.next = head;
                    head = list_head;
                }else {
                    /*insert at the tail*/
                    tail.next = list_head;
                    tail = list_head;
                }
                list_head = next;
            }
            tail.next = null;
            /*the head has changed so return it*/
            return list_head;
        }

        public static Node addLists(Node list_one, Node list_two, int carry){
            if (list_one == null && list_two == null && carry == 0) return null;
            Node result = new Node(0);
            int result_data = carry;
            if (list_one != null) result_data = result_data + list_one.data;
            if (list_two != null) result_data = result_data + list_two.data;
            result.data = result_data % 10; /*second digit of number*/
            if (list_one != null || list_two != null){
                Node more = addLists(list_one == null ? null : list_one.next, list_two == null ? null : list_two.next, carry >= 10 ? 1 : 0);
                result.next = more;
            }
            return result;
        }
        public static Node addLists(Node list_one, Node list_two){ return addLists(list_one,list_two,0);} /*need fixing*/

        public static boolean isPalindrome(Node head){
            Node slow = head, fast = head;
            Stack<Integer> stack = new Stack<>();
            /*find middle using runner technique*/
            while (fast != null && fast.next != null){
                stack.push(slow.data);
                slow = slow.next;
                fast = fast.next.next;
            }
            /*has odd number so skip middle element*/
            if (fast != null) slow = slow.next;
            while (slow != null){
                int top = stack.pop();
                /*if values are difference, it's not palindrome*/
                if (top != slow.data) return false;
                slow = slow.next;
            }
            return true;
        }


        public static void main(String[] args) {
            LinkedList linkedList = new LinkedList();
            System.out.println(getCountRecursive(linkedList.head));

            linkedList.head = new Node(1);
            Node second = new Node(2);
            Node third = new Node(3);
            linkedList.head.next = second;
            second.next = third;
            System.out.println();
            linkedList.head = insertAtFront(linkedList.head, 0);
            printList(linkedList.head);
            System.out.println();
            Node fifth = new Node(5);
            third.next = fifth;
            printList(linkedList.head);
            System.out.println();
            insertAfterNode(third,4);
            insertAtEnd(linkedList.head,6);

    //        System.out.println();
    //        LinkedList lA1 = new LinkedList();
    //        lA1.head = new Node(9);
    //        lA1.head.next = new Node(9);
    //        lA1.head.next.next = new Node(9);
    //
    //
    //        LinkedList lB1 = new LinkedList();
    //        lB1.head = new Node(1);
    //        lB1.head.next = new Node(0);
    //        lB1.head.next.next = new Node(0);
    //
    //
    //        Node list3 = addLists(lA1.head, lB1.head);
    //        printList(list3);
    //        insertAtEnd(linkedList.head,6);
    //        insertAtEnd(linkedList.head,7);
    //        insertAtEnd(linkedList.head,8);
    //        insertAtEnd(linkedList.head,8);
    //        System.out.println();
    //        printList(linkedList.head);
    //        removeDuplicates(linkedList.head);
    //        System.out.println();
    //        printList(linkedList.head);
    //        printList(linkedList.head);
    //        System.out.println();
    //        System.out.println(getMiddle(linkedList.head).data);
    //        insertAtEnd(linkedList.head,6);
    //        System.out.println(getCount(linkedList.head));
    //        printList(linkedList.head);
    //        System.out.println();
    //        /*Create loop for testing */
    //        linkedList.head.next.next.next.next = linkedList.head;
    //        System.out.println(countNodesInLinkedListNode(linkedList.head));
    //        if (detectLoopFloydCycleFindingAlgorithm(linkedList.head))
    //            System.out.println("Loop found");
    //        else
    //            System.out.println("No Loop");

    //        deleteFirstOccurentNode(linkedList.head,6);
    //        System.out.println();
    //        System.out.println(searchRecursive(linkedList.head,15));
    //        printList(linkedList.head);
    //        System.out.println();
    //        deleteNodeAtPosition(linkedList.head,3);
    //        printList(linkedList.head);
    //        System.out.println();
    //        System.out.println(searchRecursive(linkedList.head,5));
    //        System.out.println("------");
    //        System.out.println(getNthFromLast2(linkedList.head,1).data);
    //        System.out.println(getNthNodeRecursive(linkedList.head,31) + " th node");
    //        linkedList.head = deleteList(linkedList.head);
    //        printList(linkedList.head);
    //        System.out.println(getCountRecursive(linkedList.head));
        }
    }

    public static class GraphUtility {
        private static class Graph {
            int V;
            LinkedList<Integer> adjListArray[];

            Graph(int V){
                this.V = V;
                adjListArray = new LinkedList[V];

                // Create a new list for each vertex
                // such that adjacent nodes can be stored
                for (int i = 0; i < V; i++) {
                    adjListArray[i] = new LinkedList<>();
                }
            }
        }

        static void addEdge(Graph graph, int source, int destination){
            graph.adjListArray[source].add(destination);
            graph.adjListArray[destination].add(source);
        }

        // A utility function to print the adjacency list representation of graph
        static void printGraph(Graph graph){
            for (int v = 0; v < graph.V; v++) {
                System.out.println("Adjacency list of vertex "+ v);
                System.out.print("Head");
                for (Integer pCrawl: graph.adjListArray[v]){
                    System.out.print("->" +pCrawl);
                }
                System.out.println("\n");
            }
        }

        static void BFS(Graph graph, int s) {
            // Mark all the vertices as not visited(By default
            // set as false)
            boolean visited[] = new boolean[graph.V];

            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // Mark the current node as visited and enqueue it
            visited[s]=true;
            queue.add(s);

            while (queue.size() != 0) {
                // Dequeue a vertex from queue and print it
                s = queue.poll();
                System.out.print(s+" ");

                // Get all adjacent vertices of the dequeued vertex s
                // If a adjacent has not been visited, then mark it
                // visited and enqueue it
                Iterator<Integer> i = graph.adjListArray[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }

        // A function used by DFS
        static void DFSUtil(Graph graph, int v, boolean visited[]) {
            // Mark the current node as visited and print it
            visited[v] = true;
            System.out.print(v+" ");

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = graph.adjListArray[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(graph,n, visited);
            }
        }

        // The function to do DFS traversal. It uses recursive DFSUtil()
        static void DFS(Graph graph, int v) {
            // Mark all the vertices as not visited(set as
            // false by default in java)
            boolean visited[] = new boolean[graph.V];

            // Call the recursive helper function to print DFS traversal
            DFSUtil(graph,v, visited);
        }

        static void DFSDisconnected(Graph graph) {
            // Mark all the vertices as not visited(set as
            // false by default in java)
            boolean visited[] = new boolean[graph.V];

            // Call the recursive helper function to print DFS traversal
            // starting from all vertices one by one
            for (int i=0; i<graph.V; ++i)
                if (!visited[i])
                    DFSUtil(graph, i, visited);
        }

        public static void main(String args[]) {
            // create the graph given in above figure
            int V = 5;
            Graph graph = new Graph(V);
            addEdge(graph, 0, 1);
            addEdge(graph, 0, 4);
            addEdge(graph, 1, 2);
            addEdge(graph, 1, 3);
            addEdge(graph, 1, 4);
            addEdge(graph, 2, 3);
            addEdge(graph, 3, 4);

            // print the adjacency list representation of
            // the above graph
            //printGraph(graph);


            //System.out.println("Following is Breadth First Traversal "+
                    //"(starting from vertex 2)");

            //BFS(graph, 2);

            //System.out.println("Following is Depth First Traversal "+
                    //"(starting from vertex 2)");

            //DFS(graph,2);
            DFSDisconnected(graph);
        }
    }
}
