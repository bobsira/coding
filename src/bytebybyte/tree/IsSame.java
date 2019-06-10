package bytebybyte.tree;

import java.util.LinkedList;
import java.util.Queue;

public  class IsSame {

    private static boolean isSame(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null) return false;

        //return isSame( root1.left, root2.left ) && isSame(root1.right, root2.right) ;

        // Two trees are identical when they have same data and arrangement of data is also same.
        return root1.data == root2.data && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);

    }

    /**
     * Analysis
     * When we say structurally identical trees, we mean that both the trees have exactly the same number of nodes,
     * arranged in the exactly same way. It is not necessary that the value of each node should also be the same.
     * Since, we need to traverse each node of the tree and each node has the same property of having a data value,
     * a left child and a right child, we will proceed with the method of recursion.
     * The algorithm we will follow will be therefore:-
     * If both trees are NULL, return true.
     * If both trees are not NULL, then compare data and recursively check left and right sub-tree structures.
     * Time Complexity: of the will be according to the tree with lesser number of nodes.
     * Let number of nodes in two trees be m and n then complexity of is O(m) where m < n
     * Space Complexity:- O(n) for the recursive stack
     */

    private static boolean isSameIterative(Node root1, Node root2) {
        // Return true if both trees are empty
        if (root1 == null && root2 == null) return true;

        // Return false if one is empty and other is not
        if (root1 == null || root2 == null) return false;

        // Create an empty queues for simultaneous traversals
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();

        // Enqueue Roots of trees in respective queues
        queue1.add(root1);
        queue2.add(root2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // Get front nodes and compare them
            Node node1 = queue1.peek();
            Node node2 = queue2.peek();

            if (node1.data != node2.data) return false;

            // Remove front nodes from queues
            queue1.remove();
            queue2.remove();

            /* Enqueue left children of both nodes */
            if (node1.left != null && node2.left != null) {
                queue1.add(node1.left);
                queue2.add(node2.left);
            } else if (node1.left != null || node2.left != null)
                return false; // If one left child is empty and other is not

            /* Enqueue right children of both nodes */
            if (node1.right != null && node2.right != null) {
                queue1.add(node1.right);
                queue2.add(node2.right);
            } else if (node1.right != null || node2.right != null)
                return false; // If one right child is empty and other is not
        }
        return true;
    }

    /**
     * Time complexity of above solution is O(n + m) where m and n are number of nodes in two trees.
     */

    public static void main(String[] args) {

        Node root1 = new Node(6);
        Insert.insert(root1, 2);
        Insert.insert(root1, 3);
        Insert.insert(root1, 7);
        Insert.insert(root1, 5);

        BinaryTree tree = new BinaryTree(root1);

        Node root2 = new Node(6);
        Insert.insert(root2, 2);
        Insert.insert(root2, 3);
        Insert.insert(root2, 7);
        Insert.insert(root2, 5);

        BinaryTree tree2 = new BinaryTree(root2);
        System.out.println(isSameIterative(tree.root, tree2.root));

    }
}