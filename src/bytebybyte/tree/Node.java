package bytebybyte.tree;

public class Node {

    int data;
    Node left , right;
    Node parent; //this is for the special inorder successor

    Node(int data){
        this.data = data;
        left = right = parent = null;
    }
}
