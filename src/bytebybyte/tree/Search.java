package bytebybyte.tree;

public class Search {

    static Node searchNode(Node root, int data){
        if (root == null) return null;
        else if (data == root.data) return root;
        else if (data <= root.data) return searchNode(root.left, data);
        else return searchNode(root.right, data);
    }

    static boolean search(Node root, int data){
        if (root == null) return false;
        else if (data == root.data) return true;
        else if (data <= root.data) return search(root.left, data);
        else return search(root.right, data);
    }
}
