package bytebybyte.tree;

public class Delete {

    static Node delete(Node root, int data){
        if (root == null) return root;
        else if (data < root.data) root.left = delete(root.left, data);
        else if (data > root.data) root.right = delete(root.right, data);
            //found the node delete it now
        else {
            //case 1: zero child
            if (root.left == null && root.right == null) return null;
            //case 2: one child
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            //case 3: two child
            else {
                root.data = Minimum.minValue(root.right);
                root.right =  delete(root.right, root.data);
            }
        }
        return root;
    }
}
