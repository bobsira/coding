package codes;

import java.util.*;

public class BigThree {

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

        public static int countNodes(Node start) {
            int count = 1;
            Node current = start;
            while (current.next != start){
                count = count + 1;
                current = current.next;
            }
            return count;
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
