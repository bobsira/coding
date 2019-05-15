package bytebybyte.tree;

public class Minimum {

    static Node minNode(Node root){
        while (root.left != null) root = root.left;
        return root;
    }

    static int minValue(Node root){
        while (root.left != null) root = root.left;
        return root.data;
    }

    static int minValueRecursively(Node root){
        if (root == null) return -1;
        if (root.left == null) return root.data;
        return minValueRecursively(root.left);
    }
}
