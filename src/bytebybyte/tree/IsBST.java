package bytebybyte.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsBST {

    private static boolean isBSTUtil(Node root, int min, int max){
        if (root == null) return true;
        if (root.data > min && root.data < max
                && isBSTUtil(root.left, min, root.data)
                && isBSTUtil(root.right, min, root.data))
            return true;
        else return false;
    }

    static boolean isBST(Node root){
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBST2(Node root){
        int previous = Integer.MIN_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.peek();
            if (current.data > previous)
                previous = current.data;
            else
                return false;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
            queue.remove();
        }
        return true;
    }


    static boolean isBST3(Node root){
        if (root == null) return true;
        if (isSubtreeLesser(root.left, root.data) && isSubtreeGreater(root.right, root.data) && isBST(root.left) && isBST(root.left)) return true;
        else return false;
    }
    private static boolean isSubtreeLesser(Node root, int value){
        if (root == null) return true;
        if (root.data < value && isSubtreeLesser(root.left, value) && isSubtreeLesser(root.right, value)) return true;
        else return false;
    }
    private static boolean isSubtreeGreater(Node root, int value){
        if (root == null) return true;
        if (root.data > value && isSubtreeGreater(root.left, value) && isSubtreeGreater(root.right, value)) return true;
        return false;
    }


}
