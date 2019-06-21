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

}
