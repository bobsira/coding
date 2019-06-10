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


            Node deleteOPT(Node root, int data){
                if (root == null) return root;
                else if (data < root.data) {
                    root.left = deleteOPT(root.left, data);
                    return root;
                }
                else if (data > root.data) {
                    root.right = deleteOPT(root.right, data);
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
