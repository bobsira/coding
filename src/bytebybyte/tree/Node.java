package bytebybyte.tree;

public class Node {

    public int data;
    public Node left , right;
    public Node parent; //this is for the special inorder successor

    public Node(int data){
        this.data = data;
        left = right = parent = null;
    }
}
