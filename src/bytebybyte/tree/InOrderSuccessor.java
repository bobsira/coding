package bytebybyte.tree;

public class InOrderSuccessor {

    static Node getSuccessor(Node root, int data){
        Node current = Search.searchNode(root, data);
        if(current == null) return null;
        if (current.right != null) return Minimum.minNode(current.right); // case 1: Node has right sub tree o(h)
        else {
            //case 2: No right sub-tree o(h)
            Node ancestor = root;
            Node successor = null;
            while ( ancestor != current){
                if (current.data < ancestor.data){
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else ancestor = ancestor.right;
            }
            return successor;
        }
    }

    Node inOrderSuccessor(Node node){
        if (node == null) return null;
        if (node.right != null) return Minimum.minNode(node.right);
        else {
            Node parent = node.parent;
            while (parent != null && node == parent.right){
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }
}
