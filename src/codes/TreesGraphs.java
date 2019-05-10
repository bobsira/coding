package codes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TreesGraphs {

    public static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        private int size = 0;

        public TreeNode(int d){
            data = d;
            size = 1;
        }

        private void setLeftChild(TreeNode left){
            this.left = left;
            if (left != null) left.parent = this;
        }

        public void setRightChild(TreeNode right){
            this.right = right;
            if (right != null) right.parent = this;
        }

        public void insertInOrder(int d){
            if (d <= data){
                if(left == null) setLeftChild(new TreeNode((d)));
                else left.insertInOrder(d);
            }else {
                if (right == null) setRightChild(new TreeNode(d));
                else right.insertInOrder(d);
            }
            size++;
        }

    }

    private static class Node {
        private Node adjacent[];
        public int adjacentCount;
        private String vertex;
        public State state;
        public Node(String vertex, int adjacentLength) {
            this.vertex = vertex;
            adjacentCount = 0;
            adjacent = new Node[adjacentLength];
        }

        public void addAdjacent(Node x) {
            if (adjacentCount < adjacent.length) {
                this.adjacent[adjacentCount] = x;
                adjacentCount++;
            } else {
                System.out.print("No more adjacent can be added");
            }
        }
        public Node[] getAdjacent() {
            return adjacent;
        }
        public String getVertex() {
            return vertex;
        }
    }

    private static class Graph {
        public static int MAX_VERTICES = 6;
        private Node vertices[];
        public int count;
        public Graph() {
            vertices = new Node[MAX_VERTICES];
            count = 0;
        }

        public void addNode(Node x) {
            if (count < vertices.length) {
                vertices[count] = x;
                count++;
            } else {
                System.out.print("Graph full");
            }
        }

        public Node[] getNodes() {
            return vertices;
        }
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    public static void printResult(ArrayList<LinkedList<TreeNode>> result){
        int depth = 0;
        for (LinkedList<TreeNode> entry: result){
            Iterator<TreeNode> iterator = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while (iterator.hasNext()) System.out.print(" " + ((TreeNode) iterator.next()).data);
            System.out.println();
            depth++;
        }
    }

    public static TreeNode createTreeFromArray(int[] array) {
        if (array.length > 0) {
            TreeNode root = new TreeNode(array[0]);
            java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
            queue.add(root);
            boolean done = false;
            int i = 1;
            while (!done) {
                TreeNode r = (TreeNode) queue.element();
                if (r.left == null) {
                    r.left = new TreeNode(array[i]);
                    i++;
                    queue.add(r.left);
                } else if (r.right == null) {
                    r.right = new TreeNode(array[i]);
                    i++;
                    queue.add(r.right);
                } else {
                    queue.remove();
                }
                if (i == array.length) {
                    done = true;
                }
            }
            return root;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {

        /**Graph g = createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[3];
        Node end = n[5];
        System.out.println(search(g, start, end));*/

        /**int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = createMinimalBST(array);
        System.out.println("Root? " + root.data);

        System.out.println("Is balanced? " + isBalancedB(root));
        root.insertInOrder(4); // Add 4 to make it unbalanced
        System.out.println("Is balanced? " + isBalancedI(root));*/

        /**int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = createTreeFromArray(nodes_flattened);
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedListDFS(root);
        printResult(list);*/

        /**int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};
        TreeNode node = createMinimalBST(array);
        boolean isBst = checkBST(node);
        System.out.println(isBst);*/
    }

    //1. ROUTE BETWEEN NODES
    public enum State {
        Unvisited, Visited, Visiting;
    }
    public static boolean search(Graph g, Node start, Node end){
        LinkedList<Node> q = new LinkedList<>();
        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Node u;
        while (!q.isEmpty()){
            u = q.removeFirst();
            if (u != null){
                for (Node v : u.getAdjacent()){
                    if (v.state == State.Unvisited){
                        if (v ==end){
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }

    //2. MINIMAL TREES
    public static TreeNode createMinimalBST(int[] array){
        return createMinimalBST(array, 0, array.length - 1);
    }

    public static TreeNode createMinimalBST(int arr[], int start, int end){
        if (end < start) return null;
        int mid = ( start + end ) / 2 ;
        TreeNode node = new TreeNode(arr[mid]);
        node.setLeftChild(createMinimalBST(arr, start, mid - 1));
        node.setRightChild(createMinimalBST(arr, mid + 1, end));
        return node;
    }

    //3. LIST OF DEPTHS
    // DFS
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListDFS(TreeNode root){
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedListDFS(root, lists, 0);
        return lists;
    }

    public static void createLevelLinkedListDFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
        if (root == null) return;
        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedListDFS(root.left, lists, level + 1);
        createLevelLinkedListDFS(root.right, lists, level + 1);
    }

    // BFS
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) current.add(root);
        while (current.size() > 0){
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for (TreeNode parent: parents){
                if (parent.left != null) current.add(parent.left);
                if (parent.right != null) current.add(parent.right);
            }
        }
        return result;
    }

    //4. CHECK BALANCED
    //BRUTE FORCE
    public static int getHeight(TreeNode root){
        if (root == null) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right));
    }
    public static boolean isBalancedB(TreeNode root){
        if (root == null) return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) return  false;
        else return isBalancedB(root.left) && isBalancedB(root.right);
    }

    //IMPROVED
    public static int checkHeight(TreeNode root){
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Propagate error up

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Propagate error up

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1 ) return Integer.MIN_VALUE; // Found error -> pass it back
        else return Math.max(leftHeight, rightHeight) + 1;
    }
    public static boolean isBalancedI(TreeNode root){
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    //VALIDATE BST
    public static boolean checkBST(TreeNode node, Integer min, Integer max){
        if (node == null) return  true;
        if ( (min != null && node.data <= min) || (max != null && node.data > max) ) return false;
        if (!checkBST(node.left, min, node.data) || !checkBST(node.right, node.data, max)) return false;
        return true;
    }
    public static boolean checkBST(TreeNode node){
        return checkBST(node, null, null);
    }

}
