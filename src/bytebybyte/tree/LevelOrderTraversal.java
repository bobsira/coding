package bytebybyte.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node temp = queue.peek();
            System.out.print(temp.data + " ");
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
            queue.remove();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        Insert.insert(root,2);
        Insert.insert(root,3);
        Insert.insert(root,7);
        Insert.insert(root,5);

        BinaryTree tree = new BinaryTree(root);
        LevelOrderTraversal.levelOrder(tree.root);


    }
}
